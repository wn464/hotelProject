package com.project.dao;

import java.util.List;

import com.project.bean.CommentBean;

public interface ICommentDao {

	public int findCountByFoodId(int id);
	public List<CommentBean> findByFoodId(int id);
	public int addComment(CommentBean comment);
}
