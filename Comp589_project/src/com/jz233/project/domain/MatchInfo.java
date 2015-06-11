package com.jz233.project.domain;

public class MatchInfo {
	
	private int matchId;
	private String matchDate;
	private String hmName;
	private String awName;
	private boolean hmWin;
	private String hmScore;
	private String awScore;
	private int OTs;
	private String imgUrl;
	private String detailsUrl;
	
	
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public String getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}
	public String getHmName() {
		return hmName;
	}
	public void setHmName(String hmName) {
		this.hmName = hmName;
	}
	public String getAwName() {
		return awName;
	}
	public void setAwName(String awName) {
		this.awName = awName;
	}
	public boolean isHmWin() {
		return hmWin;
	}
	public void setHmWin(boolean hmWin) {
		this.hmWin = hmWin;
	}
	public String getHmScore() {
		return hmScore;
	}
	public void setHmScore(String hmScore) {
		this.hmScore = hmScore;
	}
	public String getAwScore() {
		return awScore;
	}
	public void setAwScore(String awScore) {
		this.awScore = awScore;
	}
	public int getOTs() {
		return OTs;
	}
	public void setOTs(int oTs) {
		OTs = oTs;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getDetailsUrl() {
		return detailsUrl;
	}
	public void setDetailsUrl(String detailsUrl) {
		this.detailsUrl = detailsUrl;
	}
	@Override
	public String toString() {
		return "MatchInfo [matchId=" + matchId + ", matchDate=" + matchDate
				+ ", hmName=" + hmName + ", awName=" + awName + ", hmWin="
				+ hmWin + ", hmScore=" + hmScore + ", awScore=" + awScore
				+ ", OTs=" + OTs + ", imgUrl=" + imgUrl + ", detailsUrl="
				+ detailsUrl + "]";
	}
	
	
	
	
}
