package com.jz233.project.dao;

import java.util.List;
import java.util.Map;

import com.jz233.project.domain.InfoAndFeature;
import com.jz233.project.domain.MatchInfo;

public interface MatchInfoDao {
	public List<MatchInfo> doShow();
	
	public List<MatchInfo> doSearch(String match_date, String hm_name, String aw_name,
			String hm_conference,String hm_division,String aw_conference,String aw_division,String winner);
	
	public boolean doUpdate(List<MatchInfo> matchInfo,String match_date);
	
	
	public Map<String, Object> getMatchReview(int match_id);
	
	public InfoAndFeature loadMatchInfoAndFeature(int match_id);
}
