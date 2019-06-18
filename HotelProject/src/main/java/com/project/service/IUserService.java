package com.project.service;

import com.project.bean.UserBean;

public interface IUserService {

	/**
	 * 登录，验证密码是否正确
	 * @param user
	 * @return
	 */
	public UserBean login(UserBean user);
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	public int register(UserBean user);
	/**
	 * 修改密码
	 * @param user
	 * @return
	 */
	public int changePassword(UserBean user);
}
