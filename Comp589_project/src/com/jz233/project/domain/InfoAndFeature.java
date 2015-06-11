package com.jz233.project.domain;

public class InfoAndFeature {

	private String matchDate;
	private String hmName;
	private String awName;
	private int hmScore;
	private int awScore;
	private boolean hmWin;
	private int styleIdx;
	private int tempoIdx;
	private int intensityIdx;
	private int commentCounts;
	
	public int getCommentCounts() {
		return commentCounts;
	}
	public void setCommentCounts(int commentCounts) {
		this.commentCounts = commentCounts;
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
	public void setAwTeam(String awTeam) {
		this.awName = awTeam;
	}
	public int getHmScore() {
		return hmScore;
	}
	public void setHmScore(int hmScore) {
		this.hmScore = hmScore;
	}
	public int getAwScore() {
		return awScore;
	}
	public void setAwScore(int awScore) {
		this.awScore = awScore;
	}
	public boolean isHmWin() {
		return hmWin;
	}
	public void setHmWin(boolean hmWin) {
		this.hmWin = hmWin;
	}
	public int getStyleIdx() {
		return styleIdx;
	}
	public void setStyleIdx(int styleIdx) {
		this.styleIdx = styleIdx;
	}
	public int getTempoIdx() {
		return tempoIdx;
	}
	public void setTempoIdx(int tempoIdx) {
		this.tempoIdx = tempoIdx;
	}
	public int getIntensityIdx() {
		return intensityIdx;
	}
	public void setIntensityIdx(int intensityIdx) {
		this.intensityIdx = intensityIdx;
	}
	@Override
	public String toString() {
		return "InfoAndFeature [matchDate=" + matchDate + ", hmName=" + hmName
				+ ", awName=" + awName + ", hmScore=" + hmScore + ", awScore="
				+ awScore + ", hmWin=" + hmWin + ", styleIdx=" + styleIdx
				+ ", tempoIdx=" + tempoIdx + ", intensityIdx=" + intensityIdx
				+ ", commentCounts=" + commentCounts + "]";
	}


}
