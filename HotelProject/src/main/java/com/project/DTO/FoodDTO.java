package com.project.DTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.bean.FoodBean;
import com.project.bean.TypeBean;
import com.project.dao.ICommentDao;
@Component
public class FoodDTO {

	private int id;
	private String name;
	private double prince;
	private TypeBean type;
	private int commentNum;
	
	
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public FoodDTO() {
		
	}
	public FoodDTO(FoodBean food) {
		this.id=food.getId();
		this.name  = food.getName();
		this.prince = food.getPrince();
		this.type=food.getType();
	}
	/**
	 * List<FoodBean> 转换为 List<FoodDTO>
	 * @param list
	 * @return
	 */
	public static List<FoodDTO> listBeanToDto(List<FoodBean> list){
		List<FoodDTO> listDTO = new ArrayList<FoodDTO>();
		for (FoodBean foodBean : list) {
			FoodDTO foodDTO = new FoodDTO(foodBean);
			listDTO.add(foodDTO);
		}
		return listDTO;
	}
	
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
	
}
