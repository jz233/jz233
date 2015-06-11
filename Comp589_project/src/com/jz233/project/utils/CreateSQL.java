package com.jz233.project.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CreateSQL {
	public static String buildSQL(String match_date, String hm_name, String aw_name,
			String hm_conference,String hm_division,String aw_conference,String aw_division, String winner){
		
		String sql = "SELECT match_info.*, t1.`team_division` AS hm_division, t1.`team_conference` AS hm_conference, " +
				"t2.`team_division` AS aw_division, t2.`team_conference` AS aw_conference FROM match_info " +
				"LEFT JOIN team_info t1 ON match_info.hm_name = t1.team_name " +
				"LEFT JOIN team_info t2 ON match_info.`aw_name` = t2.`team_name`";
		StringBuffer sb = new StringBuffer(sql);
		Map<String, String> paramMap = getParameterMap(match_date, hm_name, aw_name, hm_conference, hm_division, aw_conference, aw_division, winner);
		
		Set<Map.Entry<String, String>> entrySet = paramMap.entrySet();
		if(entrySet.size()==1){
			Map.Entry<String, String> entry = entrySet.iterator().next();
			sb.append("where "+entry.getKey()+" = '"+entry.getValue()+"'");
		}else if(entrySet.size()>1){
			sb.append(" where ");
			for (Entry<String, String> entry : entrySet) {
				sb.append(entry.getKey()+" = '"+entry.getValue()+"' AND ");
			}
			sb.delete(sb.lastIndexOf(" AND "), sb.length()-1);
		}
		
		return sb.toString();
	}
	
	public static Map<String,String> getParameterMap(String match_date, String hm_name, String aw_name,
			String hm_conference,String hm_division,String aw_conference,String aw_division, String winner){
		Map<String,String> paramMap = new HashMap<String, String>();

		if(!hm_conference.equals("Please Select")){
			paramMap.put("t1.`team_conference`", hm_conference);
		}if(!hm_division.equals("Please Select")){
			paramMap.put("t1.`team_division`", hm_division);
		}if(!hm_name.equals("Please Select")){
			paramMap.put("hm_name", TeamNameMapping.getTeamName(hm_name));
		}if(!aw_conference.equals("Please Select")){
			paramMap.put("t2.`team_conference`", aw_conference);
		}if(!aw_division.equals("Please Select")){
			paramMap.put("t2.`team_division`", aw_division);
		}if(!aw_name.equals("Please Select")){
			paramMap.put("aw_name", TeamNameMapping.getTeamName(aw_name));
		}if(match_date != null && !match_date.equals("")){
			paramMap.put("match_date", match_date.replace("-", ""));
		}if(!winner.equals("2")){
			paramMap.put("hm_win", winner);
		}
		
		return paramMap;
	}
	
}
