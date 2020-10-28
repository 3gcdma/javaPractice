package com.ssafy.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.test.dto.UserInfo;
import com.ssafy.test.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;
	
	@Override
	public UserInfo login(UserInfo userInfo) throws Exception {
		return mapper.selectLogin(userInfo);
	}
}
