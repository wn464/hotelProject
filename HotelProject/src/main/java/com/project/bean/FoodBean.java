package com.project.bean;

import javax.validation.constraints.NotBlank;

public class FoodBean {

	@NotBlank(message = "id不能为空")
	private int id;
	private String name;
	private double prince;
	private TypeBean type;
	private String img;
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
	public double getPrince() {
		return prince;
	}
	public void setPrince(double prince) {
		this.prince = prince;
	}
	public TypeBean getType() {
		return type;
	}
	public void setType(TypeBean type) {
		this.type = type;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "FoodBean [id=" + id + ", name=" + name + ", prince=" + prince + ", type=" + type + ", img=" + img + "]";
	}
	
}
