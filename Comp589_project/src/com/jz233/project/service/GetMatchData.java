package com.jz233.project.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.jz233.project.dao.MatchInfoDao;
import com.jz233.project.domain.MatchInfo;

public class GetMatchData {

	private String awScore;
	private String hmScore;
	private Element awTeam;
	private Element hmTeam;
	private String hmName;
	private String awName;
	
	private MatchInfoDao matchInfoDao;
	public void setDao(MatchInfoDao dao) {
		this.matchInfoDao = dao;
	}
	
	/**
	 * get yesterday's match info
	 */
	public void execute(){
			try {
				//get yesterday's date in yyyyMMdd format
				/*Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DATE, -1);
				Date date = calendar.getTime();
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				String date_string = format.format(date);

				
				List<MatchInfo> recapData = getRecapData(date_string);
				matchInfoDao.doUpdate(recapData,date_string);
				recapData=null;
				
				System.out.println("yesterday:" + date_string);*/
				
				//assume that today is 2015-05-25
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				Calendar cal = Calendar.getInstance();
				cal.set(2015, 4, 24);
				Date date = cal.getTime();
				
				String date_string = format.format(date);
				List<MatchInfo> recapData = getRecapData(date_string);
				matchInfoDao.doUpdate(recapData,date_string);
				recapData=null;
					
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	@Test
	public void test(){
		
			//assume that today is 2015-05-21
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			Calendar cal = Calendar.getInstance();
			cal.set(2015, 4, 14);	//Month value is 0-based.
			Date date = cal.getTime();
			
			String date_string = format.format(date);
			try {
				List<MatchInfo> recapData = getRecapData(date_string);
				for (MatchInfo matchInfo : recapData) {
					System.out.println(matchInfo.toString());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public List<MatchInfo> getRecapData(String date) throws IOException {
		
		Document document = Jsoup.connect("http://www.nba.com/gameline/"+date+"/").get();
		Elements elements = document.select("div[class$=GameLine]");	//All
		List<MatchInfo> matchInfoList;
		
		if(!elements.isEmpty()){
			matchInfoList = new ArrayList<MatchInfo>();
			for (Element element : elements) {
				MatchInfo matchInfo = new MatchInfo();
				
				awTeam = element.getElementsByAttributeValue("class", "nbaModTopTeamAw").first();
				hmTeam = element.getElementsByAttributeValue("class", "nbaModTopTeamHm").last();
				
				hmName = hmTeam.getElementsByAttributeValue("class", "nbaModTopTeamName").text();
				awName = awTeam.getElementsByAttributeValue("class", "nbaModTopTeamName").text();
				
				Element hmWinner = hmTeam.select("div[class$=win]").first();
				if(hmWinner == null){	//客队赢球
					awScore = awTeam.getElementsByAttributeValue("class", "nbaModTopTeamNum win").text().trim();
					hmScore = hmTeam.getElementsByAttributeValue("class", "nbaModTopTeamNum").text().trim();
//					awName += "*";
					matchInfo.setHmWin(false);
				}else{	//主队赢球
					awScore = awTeam.getElementsByAttributeValue("class", "nbaModTopTeamNum").text().trim();
					hmScore = hmWinner.text().trim();
//					hmName += "*";
					matchInfo.setHmWin(true);
				}
				matchInfo.setHmName(hmName);
				matchInfo.setAwName(awName);
				matchInfo.setHmScore(hmScore);
				matchInfo.setAwScore(awScore);
				
				//加时赛
				Elements durationEles = element.select("[class=nbaMnQuBoxOT nbaShowOT]");
				if(!durationEles.isEmpty()){
					int OTs = durationEles.size()/3;	//三的倍数
					matchInfo.setOTs(OTs);
				}else{
					matchInfo.setOTs(0);
				}
				//缩略图地址
				String imgUrl = element.getElementsByAttributeValue("class", "nbaVideoWrapper").select("img[src]").attr("src");
				matchInfo.setImgUrl(imgUrl);
				//detail_url
				String detailsUrl = element.getElementsByAttributeValue("class", "nbaMnStatsFtr").select("a").attr("href");
				matchInfo.setDetailsUrl(detailsUrl);
				
				matchInfoList.add(matchInfo);
			}
			
			return matchInfoList;
		}
		return null;
		
	}
	
	
}
