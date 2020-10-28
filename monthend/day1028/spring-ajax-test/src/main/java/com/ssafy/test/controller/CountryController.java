package com.ssafy.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.test.dto.CountryStatus;
import com.ssafy.test.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {
	@Autowired
	private CountryService service;	
	
	@PostMapping("/regist.do")
	public Map<String, Object> insertCountryStatus(CountryStatus countryStatus, Model model) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			service.insertCountryStatus(countryStatus);
			result.put("result", "1");
		} catch (Exception e) {
			result.put("result", "0");
		}
		return result;

	}
	
	@GetMapping("/deletes")
//	public String deleteCountryStatus(ArrayList<String> ccodes) {
	public String deleteCountryStatus(String[] ccodes) {
		
		System.out.println(ccodes.length);
		
		service.deleteCountryStatus(ccodes);
		// 삭제후 이동할 페이지
		return "redirect:list";
	}

	@GetMapping("/list.do")
	public List<CountryStatus> selectCountryStatus() {
		return service.selectCountryStatus();
	}
	
	@PostMapping("/detail.do")
	public CountryStatus selectCountryStatusByCcode(String ccode) {
		return service.selectCountryStatusByCcode(ccode);
	}
}





