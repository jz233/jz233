package com.jz233.project.dao.impl;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.jz233.project.dao.MatchInfoDao;
import com.jz233.project.domain.InfoAndFeature;
import com.jz233.project.domain.MatchInfo;
import com.jz233.project.service.GetMatchData;
import com.jz233.project.utils.CreateSQL;
import com.jz233.project.utils.Weight;

public class MatchInfoDaoImpl extends JdbcTemplate implements MatchInfoDao {

	public List<MatchInfo> doShow() {
		
		List<MatchInfo> infoList = this.query("select * from match_info", new RowMapper<MatchInfo>() {

			public MatchInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				MatchInfo info = new MatchInfo();
				info.setMatchId(rs.getInt("match_id"));
				info.setMatchDate(rs.getString("match_date"));
				info.setHmName(rs.getString("hm_name"));
				info.setAwName(rs.getString("aw_name"));
				info.setHmWin(rs.getBoolean("hm_win"));
				info.setHmScore(rs.getString("hm_score"));
				info.setAwScore(rs.getString("aw_score"));
				info.setOTs(rs.getInt("OTs"));

				return info;
			}
			
		});
		
		
		return infoList;
	}

	
	public List<MatchInfo> doSearch(String match_date, String hm_name, String aw_name,
			String hm_conference,String hm_division,String aw_conference,String aw_division,String winner) {
		List<MatchInfo> infoList = null;

		String sql = CreateSQL.buildSQL(match_date.trim(), hm_name, aw_name,hm_conference,hm_division,aw_conference,aw_division,winner);
		System.out.println(sql);
		infoList = this.query(sql, new RowMapper<MatchInfo>() {

			public MatchInfo mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				
				MatchInfo info = new MatchInfo();
				info.setMatchId(rs.getInt("match_id"));
				info.setMatchDate(rs.getString("match_date"));
				info.setHmName(rs.getString("hm_name"));
				info.setAwName(rs.getString("aw_name"));
				info.setHmWin(rs.getBoolean("hm_win"));
				info.setHmScore(rs.getString("hm_score"));
				info.setAwScore(rs.getString("aw_score"));
				info.setOTs(rs.getInt("OTs"));
				info.setImgUrl(rs.getString("img_url"));
				
				
				return info;
			}

		});
		
		return infoList;
	}

	
	
	public boolean doUpdate(final List<MatchInfo> matchInfo, final String match_date) {

		try {
			
			if(matchInfo != null){
				String sql = "insert into match_info (match_date,hm_name,aw_name,hm_win,hm_score,aw_score,OTs,img_url,details_url) values(?,?,?,?,?,?,?,?,?)";
				this.batchUpdate(sql, new BatchPreparedStatementSetter() {
					
					public void setValues(PreparedStatement ps, int pos) throws SQLException {
						String matchDate = match_date;
						String hmName = matchInfo.get(pos).getHmName().toUpperCase();
						String awName = matchInfo.get(pos).getAwName().toUpperCase();
						boolean hmWin = matchInfo.get(pos).isHmWin();
						String hmScore = matchInfo.get(pos).getHmScore();
						String awScore = matchInfo.get(pos).getAwScore();
						int OTs = matchInfo.get(pos).getOTs();
						String imgUrl = matchInfo.get(pos).getImgUrl();
						String detailsUrl = matchInfo.get(pos).getDetailsUrl();
						
						ps.setString(1, matchDate);
						ps.setString(2, hmName);
						ps.setString(3, awName);
						ps.setBoolean(4, hmWin);
						ps.setString(5, hmScore);
						ps.setString(6, awScore);
						ps.setInt(7, OTs);
						ps.setString(8, imgUrl);
						ps.setString(9, detailsUrl);
					}
					
					public int getBatchSize() {
						return matchInfo.size();
					}
				});
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
		
	}


	public Map<String, Object> getMatchReview(int match_id) {
		String sql = "select details_url from match_info where match_id = "+match_id;
		
		List<String> details_url_list = this.query(sql, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int pos) throws SQLException {
				String detailsUrl = rs.getString("details_url");
				return detailsUrl;
			}
		});
		String details_url = details_url_list.get(0);
		
		try {
			Document document = Jsoup.connect("http://www.nba.com"+ details_url).get();
			Elements elements = document.select("#nbaGIRecap2");
			
			String title = elements.select("h3").first().text();
			String review = elements.select("p").toString();
			Map<String,Object> resultMap = new HashMap<String, Object>();
			resultMap.put("matchid", String.valueOf(match_id));
			resultMap.put("title", title);
			
			String[] arr = review.split("<p>");
			ArrayList<String> reviewList = new ArrayList<String>();
			for (int i = 0; i < arr.length; i++) {
				arr[i] = "<p>" + arr[i];
				reviewList.add(arr[i]);
			}
			resultMap.put("review", reviewList);
			
			return resultMap;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}


	public InfoAndFeature loadMatchInfoAndFeature(int match_id) {
		String sql="SELECT match_info.*, COUNT(match_comments.`comment_time`) AS comment_counts, match_style.`style_pts`,match_style.`tempo_pts`,match_style.`intensity_pts`" +
				" FROM match_info, match_style,match_comments" +
				" WHERE match_info.`match_id`=match_style.`match_id` AND match_style.`match_id`=match_comments.`match_id` AND match_info.match_id=?";
		List<InfoAndFeature> iafList = this.query(sql, new Object[]{match_id}, new RowMapper<InfoAndFeature>() {

			public InfoAndFeature mapRow(ResultSet rs, int pos) throws SQLException {
				InfoAndFeature iaf = new InfoAndFeature();
				iaf.setMatchDate(rs.getString("match_date"));
				iaf.setHmName(rs.getString("hm_name"));
				iaf.setAwName(rs.getString("aw_name"));
				iaf.setHmScore(rs.getInt("hm_score"));
				iaf.setAwScore(rs.getInt("aw_score"));
				iaf.setHmWin(rs.getBoolean("hm_win"));
				iaf.setCommentCounts(rs.getInt("comment_counts"));
				int styleIdx = Weight.calcWeightTwo(rs.getInt("style_pts"));
				int tempoIdx = Weight.calcWeightFive(rs.getInt("tempo_pts"),rs.getInt("comment_counts"));
				int intensityIdx = Weight.calcWeightFive(rs.getInt("intensity_pts"),rs.getInt("comment_counts"));
				iaf.setStyleIdx(styleIdx);
				iaf.setTempoIdx(tempoIdx);
				iaf.setIntensityIdx(intensityIdx);
				
				System.out.println(iaf.toString());
				return iaf;
			}
		});
		
		return iafList.get(0);
	}

	

}
