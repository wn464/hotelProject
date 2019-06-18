package com.project.service;

import java.util.List;

import com.project.bean.CommentBean;

public interface ICommentService {

	public List<CommentBean> findByFoodId(int id);
	public int addComment(CommentBean comment);
}
