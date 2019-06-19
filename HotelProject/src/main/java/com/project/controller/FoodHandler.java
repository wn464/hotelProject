package com.project.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.bean.CommentBean;
import com.project.bean.FoodBean;
import com.project.bean.UserBean;
import com.project.service.ICommentService;
import com.project.service.IFoodService;

@Controller
@RequestMapping
public class FoodHandler {

	
	@Autowired
	IFoodService foodservice;
	@Autowired
	ICommentService commentservice;
	//加载信息
	@GetMapping("/good/{id}")
	public String getFood(@PathVariable int id,ModelMap map) {
		System.out.println(id);
		FoodBean food = foodservice.findById(id);
		List<CommentBean> commentList = commentservice.findByFoodId(id);
		for (CommentBean commentBean : commentList) {
			System.out.println(commentBean);
		}
		map.addAttribute("food", food);
		map.addAttribute("list", commentList);
		return "/show.html";
	}
	//加载评论
	@PatchMapping("/good/{id}")
	@ResponseBody
	public List<CommentBean> patchComment(@PathVariable int id){
		List<CommentBean> commentList = commentservice.findByFoodId(id);
		return commentList;
	}
	//发送评论
	@PutMapping("/good/{id}")
	@ResponseBody
	public int postComment(String message,@PathVariable int id,HttpSession session) {
		if(message=="") {
			return 0;
		}
		int num=0;
		System.out.println(message);
		int uid = (int) session.getAttribute("uid");
		CommentBean comment = new CommentBean();
		
		Date date = new Date(System.currentTimeMillis());
		comment.setDate(date);
		FoodBean food = new FoodBean();
		food.setId(id);
		comment.setFood(food);
		UserBean user = new UserBean();
		user.setId(uid);
		comment.setUser(user);
		System.out.println(comment);
		num = commentservice.addComment(comment);
		return num;
	}
}
