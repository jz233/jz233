package com.jz233.project.dao;

import java.util.List;

import com.jz233.project.domain.Comment;
import com.jz233.project.domain.CommentHasPts;

public interface MatchCommentDao {
	public void doPostComment(String matchid, String style, String tempo, String intensity, String desciption);
	
	public List<Comment> doLoadComments(int matchid);
	
	/**
	 * get latest comments (simulate pushing)
	 */
	public List<CommentHasPts> toListenNewComments(int matchid, Long latestTimeStamp);

}
