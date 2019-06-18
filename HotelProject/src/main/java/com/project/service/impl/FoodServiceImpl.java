package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.project.DTO.FoodDTO;
import com.project.bean.FoodBean;
import com.project.dao.ICommentDao;
import com.project.dao.IFoodDao;
import com.project.service.IFoodService;
@Service
@CacheConfig(cacheNames = {"food"})//配置缓存命名空间

public class FoodServiceImpl implements IFoodService {
//更新@CachePut(value = "emp", key = "targetClass + #p0")
//清除一条缓存，key为要清空的数据@CacheEvict(value="emp",key="#id")
//方法调用后清空所有缓存 @CacheEvict(value="accountCache",allEntries=true)
//方法调用前清空所有缓存@CacheEvict(value="accountCache",beforeInvocation=true)
	@Autowired
	private IFoodDao foodDao;
	@Autowired
	ICommentDao commentdao;
	@Override
	//查询所有
	@Cacheable(value = "emp" ,key = "targetClass + methodName +#p0")//创建缓存
	public List<FoodDTO> findAll() {
		List<FoodBean> listBean = foodDao.findAll();
		List<FoodDTO> listDTO =  FoodDTO.listBeanToDto(listBean);
		for (FoodDTO foodDTO : listDTO) {
			foodDTO.setCommentNum(commentdao.findCountByFoodId(foodDTO.getId()));
		}
		return listDTO;
	}

	@Override
	public FoodBean findById(int id) {
		FoodBean food = foodDao.findById(id);
		return food;
	}

}
