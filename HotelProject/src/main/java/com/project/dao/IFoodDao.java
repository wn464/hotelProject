package com.project.dao;

import java.util.List;

import com.project.bean.FoodBean;

public interface IFoodDao {

	public List<FoodBean> findAll();
	public FoodBean findById(int id);
	/**
	 * 返回主键
	 * @param food
	 * @return
	 */
	public int addFood(FoodBean food);
}
