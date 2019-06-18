package com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bean.UserBean;
import com.project.dao.IUserDao;
import com.project.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userdao;
	
	@Override
	public UserBean login(UserBean user) {
		
		UserBean userbean = userdao.findUser(user.getName());
		if(userbean!=null) {
			if(user.getPassword().equals(userbean.getPassword())) {
				return userbean;
			}
		}
		
		return null;
	}

	@Override
	public int register(UserBean user) {
		int result = userdao.addUser(user);
		return result;
	}

	@Override
	public int changePassword(UserBean user) {
		UserBean userbean = userdao.findUser(user.getName());
		if(!userbean.getPassword().equals(user.getPassword())) {
			int result = userdao.updatePassword(userbean);
			return result;
		}
		return 0;
	}

}
