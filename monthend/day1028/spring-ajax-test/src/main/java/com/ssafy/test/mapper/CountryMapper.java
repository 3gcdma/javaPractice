package com.ssafy.test.mapper;

import java.util.List;

import com.ssafy.test.dto.CountryStatus;

public interface CountryMapper {
	void insertCountryStatus(CountryStatus countryStatus);
	void deleteCountryStatus(String ccode);
	List<CountryStatus> selectCountryStatus();
	CountryStatus selectCountryStatusByCcode(String ccode);
}
