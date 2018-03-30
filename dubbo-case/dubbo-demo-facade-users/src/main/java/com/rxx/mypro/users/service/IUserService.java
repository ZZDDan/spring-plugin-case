package com.rxx.mypro.users.service;

import com.rxx.mypro.users.entity.User;

import java.util.List;

/**
 * @Title      :IUserService
 * @Description:
 * @Company    :zhangdan
 * @author     :zd
 * @date       :2016年12月16日 下午11:31:52
 */
public interface IUserService {

	List<User> queryPage();
}
