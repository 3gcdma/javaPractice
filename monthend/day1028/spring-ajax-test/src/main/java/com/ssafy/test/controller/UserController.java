package com.ssafy.test.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.test.dto.UserInfo;
import com.ssafy.test.service.UserService;
import com.sun.org.glassfish.external.statistics.annotations.Reset;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;
	
	
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@PostMapping("/login.do")
	@ResponseBody
	public Map<String, Object> login(UserInfo userInfo) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			UserInfo user = service.login(userInfo);
			if (user != null) {
				result.put("result", "1");
				result.put("user", user);
			} else {
				result.put("result", "0");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
}
