package com.rxx.mypro.users.controller;

import com.rxx.mypro.users.entity.User;
import com.rxx.mypro.users.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Title      :UserController
 * @Description:
 * @Company    :zhangdan
 * @author     :zd
 * @date       :2016年12月16日 下午11:31:29
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/test")
	@ResponseBody
	public Object queryUserByPage(){
		List<User> users = userService.queryPage();
		return users;
	}
}
