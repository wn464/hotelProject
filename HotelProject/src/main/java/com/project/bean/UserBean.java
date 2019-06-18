package com.project.bean;

import javax.validation.constraints.NotBlank;

public class UserBean {
	private int id;
	@NotBlank(message = "用户名为空")
	private String name;
	@NotBlank(message = "密码为空")
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	

}
