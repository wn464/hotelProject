package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bean.CommentBean;
import com.project.dao.ICommentDao;
import com.project.service.ICommentService;

@Service
public class CommentServiceImpl implements ICommentService {

	@Autowired
	private ICommentDao commentDao;
	@Override
	public List<CommentBean> findByFoodId(int id) {
		List<CommentBean> list = commentDao.findByFoodId(id);
		return list;
	}

	@Override
	public int addComment(CommentBean comment) {
		int result = commentDao.addComment(comment);
		
		System.out.println(result);
		return result;
	}

}
