package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.DTO.FoodDTO;
import com.project.bean.UserBean;
import com.project.dao.IUserDao;
import com.project.service.IFoodService;
import com.project.service.IUserService;

@Controller
@RequestMapping
public class UserController {

	@Autowired
	IUserService userservice;
	@Autowired
	IUserDao userdao;
	@Autowired
	IFoodService foodservice;
	@PostMapping("/login")
	public String login(@Validated UserBean user,BindingResult binding,HttpSession session) {
		List<FieldError> list = binding.getFieldErrors();
		if(list.size()>0) {
			for (FieldError fieldError : list) {
				String text = "login 输入错误："+fieldError.getDefaultMessage();
				System.out.println(text);
			}
			return "/login";
		}
		//认证
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
			try {
				// 调用login进行认证
				currentUser.login(token);
				System.out.println("认证成功");
				user = userdao.findUser(user.getName());
				session.setAttribute("uid", user.getId());;
				System.out.println("用户ID:"+user.getId()+"已注入httpsession");
				return "redirect:/index";
				// 找不到用户回抛出异常
			} 
			// 父异常。认证失败异常
			catch (AuthenticationException ae) {
				// unexpected condition? error?
				System.out.println("异常不详：自己解决");
				return "/login";
			}
		}

		return "redirect:/index";
		
	}
	@GetMapping("/login")
	public String getLogin() {
		return "/login.html";
	}
	@GetMapping("/index")
	public String getIndex(ModelMap map) {
		List<FoodDTO> list = foodservice.findAll();
		map.addAttribute("list", list);
		return "/index.html";
	}
	@GetMapping("/register")
	public String getResigter() {
		return "/register.html";
	}
	@PutMapping("/register")
	public String register(@Validated UserBean user,BindingResult binding) {
		List<FieldError> list = binding.getFieldErrors();
		if(list.size()>0) {
			for (FieldError fieldError : list) {
				String text = "login 输入错误："+fieldError.getDefaultMessage();
				System.out.println(text);
			}
			return "/register";
		}
		int num = userservice.register(user);
		if(num!=0) {
			return "/login";
		}else {
			return "/register";
		}
	}
}
