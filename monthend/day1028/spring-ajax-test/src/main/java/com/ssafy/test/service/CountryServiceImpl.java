package com.ssafy.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.test.dto.CountryStatus;
import com.ssafy.test.mapper.CountryMapper;

@Service
public class CountryServiceImpl implements CountryService {
	
	@Autowired CountryMapper mapper;
	@Override
	public void insertCountryStatus(CountryStatus countryStatus) {
		mapper.insertCountryStatus(countryStatus);
	}
	@Override
	public void deleteCountryStatus(String[] ccodeList) {
		for (String ccode : ccodeList) {
			mapper.deleteCountryStatus(ccode);
		}
	}
	@Override
	public List<CountryStatus> selectCountryStatus() {
		return mapper.selectCountryStatus();
	}
	@Override
	public CountryStatus selectCountryStatusByCcode(String ccode) {
		return mapper.selectCountryStatusByCcode(ccode);
	}
}
