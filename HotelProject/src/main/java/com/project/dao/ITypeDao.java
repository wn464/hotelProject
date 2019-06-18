package com.project.dao;

import com.project.bean.TypeBean;

public interface ITypeDao {

	public TypeBean findById(int id);
	public int addType(String name);
}
