package com.project.bean;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

public class CommentBean {

	private int id;
	@NotBlank(message = "用户信息不能为空")
	private UserBean user;
	@NotBlank(message = "商品不能为空")
	private FoodBean food;
	private Date date;
	@NotBlank(message = "信息不能为空")
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public FoodBean getFood() {
		return food;
	}
	public void setFood(FoodBean food) {
		this.food = food;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	
	
	
}
