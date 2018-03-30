package com.rxx.mypro.users.service.impl;

import com.rxx.mypro.users.mapper.UserMapper;
import com.rxx.mypro.users.entity.User;
import com.rxx.mypro.users.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title      :UserServiceImpl
 * @Description:
 * @Company    :zhangdan
 * @author     :zd
 * @date       :2016年12月16日 下午11:31:46
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> queryPage() {
		
		return userMapper.queryPage();
	}

}
