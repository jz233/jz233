package com.jz233.project.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.jz233.project.dao.MatchCommentDao;
import com.jz233.project.domain.Comment;
import com.jz233.project.domain.CommentHasPts;
import com.jz233.project.utils.Weight;

public class MatchCommentDaoImpl extends JdbcTemplate implements MatchCommentDao {

	public void doPostComment(String matchid, String style, String tempo,
			String intensity, String desciption) {
		
		this.update("call update_match_style(?,?,?,?,?)", Integer.parseInt(matchid), Integer.parseInt(style),Integer.parseInt(tempo),
				Integer.parseInt(intensity),desciption);
		
	}

	public List<Comment> doLoadComments(int matchid) {

		String sql = "select * from match_comments where match_id = ? ORDER BY comment_time DESC";
		List<Comment> list = this.query(sql, new Object[]{matchid}, new RowMapper<Comment>() {

			public Comment mapRow(ResultSet rs, int pos) throws SQLException {
				Comment comment = new Comment();
				comment.setMatchStyle(rs.getInt("match_style"));
				comment.setMatchTempo(rs.getInt("match_tempo"));
				comment.setMatchIntensity(rs.getInt("match_intensity"));
				comment.setDescription(rs.getString("description"));
				comment.setCommentTime(rs.getTimestamp("comment_time"));
				
				return comment;
			}
		});
		
		return list;
	}

	public List<CommentHasPts> toListenNewComments(int matchid,
			Long latestTimeStamp) {
		String latestTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(latestTimeStamp);
		String sql = "SELECT match_comments.*, (SELECT COUNT(m2.`match_id`) FROM match_comments m2 WHERE m2.`match_id`=?) AS comment_counts, match_style.`style_pts`,match_style.`tempo_pts`,match_style.`intensity_pts` FROM match_comments LEFT JOIN match_style ON match_comments.`match_id` = match_style.`match_id` WHERE match_comments.`match_id`= ? AND match_comments.`comment_time` > '"+latestTime+"' ORDER BY match_comments.`comment_time` DESC ";
		
		List<CommentHasPts> list = this.query(sql, new Object[]{matchid,matchid}, new RowMapper<CommentHasPts>() {

			public CommentHasPts mapRow(ResultSet rs, int pos) throws SQLException {
				CommentHasPts commentHasPts = new CommentHasPts();
				commentHasPts.setMatchStyle(rs.getInt("match_style"));
				commentHasPts.setMatchTempo(rs.getInt("match_tempo"));
				commentHasPts.setMatchIntensity(rs.getInt("match_intensity"));
				commentHasPts.setDescription(rs.getString("description"));
				commentHasPts.setCommentTime(rs.getTimestamp("comment_time"));
				
				commentHasPts.setStyleIdx(Weight.calcWeightTwo(rs.getInt("style_pts")));
				commentHasPts.setTempoIdx(Weight.calcWeightFive(rs.getInt("tempo_pts"), rs.getInt("comment_counts")));
				commentHasPts.setIntensityIdx(Weight.calcWeightFive(rs.getInt("intensity_pts"), rs.getInt("comment_counts")));
				
				return commentHasPts;
			}
		});
		System.out.println("list.size(): " + list.size());
		return list;
		
	}
		

}
