package com.jz233.project.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TeamNameMapping {

	
	private static Map<String,String> teamNameMap(){
		Map<String,String> map =  new HashMap<String, String>();
		//West
		map.put("Dallas Mavericks", "DAL");
		map.put("Houston Rockets", "HOU");
		map.put("Memphis Grizzlies", "MEM");
		map.put("New Orleans Pelicans", "NOP");
		map.put("San Antonio Spurs", "SAS");
		map.put("Denver Nuggets", "DEN");
		map.put("Minnesota Timbervolves", "MIN");
		map.put("Oklahoma City Thunder", "OKC");
		map.put("Portland Trail Blazers", "POR");
		map.put("Utah Jazz", "UTA");
		map.put("Golden State Warriors", "GSW");
		map.put("Los Angeles Lakers", "LAL");
		map.put("Los Angeles Clippers", "LAC");
		map.put("Phoenix Suns", "PHX");
		map.put("Sacramento Kings", "SAC");
		
		//East
		map.put("Boston Celtics", "BOS");
		map.put("Brooklyn Nets", "BKN");
		map.put("New York Knicks", "NYK");
		map.put("Philadelphia 76ers", "PHI");
		map.put("Toronto Raptors", "TOR");
		map.put("Chicago Bulls", "CHI");
		map.put("Cleveland Cavaliers", "CLE");
		map.put("Detroit Pistons", "DET");
		map.put("Indiana Pacers", "IND");
		map.put("Milwaukee Bucks", "MIL");
		map.put("Atlanta Hawks", "ATL");
		map.put("Charlotte Hornets", "CHA");
		map.put("Miami Heat", "MIA");
		map.put("Orlando Magic", "ORL");
		map.put("Washington Wizards", "WAS");
		
		return map;
		
	}
	
	public static String getTeamName(String fullName){
		Set<Entry<String,String>> entrySet = TeamNameMapping.teamNameMap().entrySet();
		for (Entry<String, String> entry : entrySet) {
			if(entry.getKey().equals(fullName)){
				return entry.getValue();
			}
		}
		
		return "";
	}
	
}
