package com.ssafy.test.service;

import com.ssafy.test.dto.UserInfo;

public interface UserService {

	UserInfo login(UserInfo userInfo) throws Exception;

}