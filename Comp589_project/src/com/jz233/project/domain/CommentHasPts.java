package com.jz233.project.domain;

import java.sql.Timestamp;

public class CommentHasPts {
	private int matchId;
	private int matchStyle;
	private int matchTempo;
	private int matchIntensity;
	private String description;
	private Timestamp commentTime;
	private int styleIdx;
	private int tempoIdx;
	private int intensityIdx;
	
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
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public int getMatchStyle() {
		return matchStyle;
	}
	public void setMatchStyle(int matchStyle) {
		this.matchStyle = matchStyle;
	}
	public int getMatchTempo() {
		return matchTempo;
	}
	public void setMatchTempo(int matchTempo) {
		this.matchTempo = matchTempo;
	}
	public int getMatchIntensity() {
		return matchIntensity;
	}
	public void setMatchIntensity(int matchIntensity) {
		this.matchIntensity = matchIntensity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Timestamp getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}
	@Override
	public String toString() {
		return "CommentHasPts [matchId=" + matchId + ", matchStyle="
				+ matchStyle + ", matchTempo=" + matchTempo
				+ ", matchIntensity=" + matchIntensity + ", description="
				+ description + ", commentTime=" + commentTime + ", styleIdx="
				+ styleIdx + ", tempoIdx=" + tempoIdx + ", intensityIdx="
				+ intensityIdx + "]";
	}
	
	
	
	
	
}
