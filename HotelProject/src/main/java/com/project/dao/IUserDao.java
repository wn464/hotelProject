package com.project.dao;



import com.project.bean.UserBean;

public interface IUserDao {

	/**
	 * 通过名字查找用户
	 * @param name
	 * @return
	 */
	public UserBean findUser(String name);
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int addUser(UserBean user);
	public int updatePassword(UserBean user);
	public UserBean findById(int id);
}
