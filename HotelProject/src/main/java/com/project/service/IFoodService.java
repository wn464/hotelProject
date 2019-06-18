package com.project.service;

import java.util.List;

import com.project.DTO.FoodDTO;
import com.project.bean.FoodBean;

public interface IFoodService {

	public List<FoodDTO> findAll();
	public FoodBean findById(int id);
}
