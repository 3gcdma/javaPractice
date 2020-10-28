package com.ssafy.test.mapper;

import com.ssafy.test.dto.UserInfo;

public interface UserMapper {
	UserInfo selectLogin(UserInfo user);
}
