package com.rxx.mypro.users.mapper;

import com.rxx.mypro.common.mapper.BaseMapper;
import com.rxx.mypro.users.entity.User;

import java.util.List;

/**
 * @Title      :UserMapper
 * @Description:
 * @Company    :zhangdan
 * @author     :zd
 * @date       :2016年12月16日 下午11:31:35
 */
public interface UserMapper extends BaseMapper {

	List<User> queryPage();
}
