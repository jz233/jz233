package com.jz233.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jz233.project.dao.MatchInfoDao;
import com.jz233.project.dao.MatchCommentDao;
import com.jz233.project.domain.Comment;
import com.jz233.project.domain.CommentHasPts;
import com.jz233.project.domain.InfoAndFeature;
import com.jz233.project.domain.MatchInfo;

@Controller
@RequestMapping("/jz233")
public class MyController {

	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "index";
	}
	
	@RequestMapping("/toDetails.do")
	public ModelAndView toDetails(HttpServletRequest request){
		
		int match_id = Integer.parseInt(request.getParameter("match_id").trim());

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("matchid", match_id);
		
		return new ModelAndView("match_details", map);
	}
	
	
	@RequestMapping("/toMatchInfo.do")
	public String toMatchInfo(Model model){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MatchInfoDao dao = (MatchInfoDao) context.getBean("matchInfoDao");
		List<MatchInfo> infoList = dao.doShow();
		model.addAttribute("list",infoList);
		
		return "success";
	}
	
	@RequestMapping(value="/toSearch.do",method=RequestMethod.POST)
	public @ResponseBody List<MatchInfo> toSearch(@RequestParam("match_date")String match_date,@RequestParam("hm_name")String hm_name,
			@RequestParam("aw_name")String aw_name, @RequestParam("hm_conference")String hm_conference,
			@RequestParam("hm_division")String hm_division, @RequestParam("aw_conference")String aw_conference,
			@RequestParam("aw_division")String aw_division,@RequestParam("winner")String winner){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MatchInfoDao dao = (MatchInfoDao) context.getBean("matchInfoDao");
		List<MatchInfo> infoList = dao.doSearch(match_date, hm_name, aw_name,hm_conference,hm_division,aw_conference,aw_division,winner);
		
		return infoList;
	}
	
	@RequestMapping(value="/toComment.do",method=RequestMethod.POST)
	public @ResponseBody String toComment(@RequestParam("matchid")String matchid, @RequestParam("style")String style, @RequestParam("tempo")String tempo, 
			@RequestParam("intensity")String intensity, @RequestParam("description")String description){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MatchCommentDao dao = (MatchCommentDao) context.getBean("MatchCommentDao");
		dao.doPostComment(matchid, style, tempo, intensity, description);
		
		return "success";
	}
	
	@RequestMapping(value="/toLoadMatchInfoAndFeature.do",method=RequestMethod.GET)
	public @ResponseBody InfoAndFeature toLoadMatchInfoAndFeature(@RequestParam("matchid")int matchid){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MatchInfoDao dao = (MatchInfoDao) context.getBean("matchInfoDao");
		InfoAndFeature infoAndFeature = dao.loadMatchInfoAndFeature(matchid);
		
		return infoAndFeature;
	}
	
	@RequestMapping(value="/toQueryReview.do",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> toQueryReview(@RequestParam("matchid")int matchid){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MatchInfoDao dao = (MatchInfoDao) context.getBean("matchInfoDao");
		Map<String, Object> matchReview = dao.getMatchReview(matchid);	
		
		return matchReview;
	}
	@RequestMapping(value="/toLoadComments.do",method=RequestMethod.GET)
	public @ResponseBody List<Comment> toLoadComments(@RequestParam("matchid")int matchid){

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MatchCommentDao dao = (MatchCommentDao) context.getBean("MatchCommentDao");
		List<Comment> commentList = dao.doLoadComments(matchid);
		
		return commentList;
	}
	@RequestMapping(value="/toListenNewComments.do",method=RequestMethod.GET)
	public @ResponseBody List<CommentHasPts> toListenNewComments(@RequestParam("matchid")int matchid, @RequestParam("latestTimeStamp")Long latestTimeStamp){

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MatchCommentDao dao = (MatchCommentDao) context.getBean("MatchCommentDao");
		List<CommentHasPts> commentList = dao.toListenNewComments(matchid, latestTimeStamp);
		
		return commentList;
	}
}
