package com.project.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.bean.UserBean;
import com.project.dao.IUserDao;

public class TestRealm extends AuthorizingRealm{

	@Autowired
	IUserDao userdao;
	//授权管理
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		return info;
	}

	//认证管理
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		Object name = token.getPrincipal();
		UserBean user = userdao.findUser(name.toString());
		AuthenticationInfo info = new SimpleAuthenticationInfo(user.getName(), user.getPassword(), getName());
		return info;
	}

}
