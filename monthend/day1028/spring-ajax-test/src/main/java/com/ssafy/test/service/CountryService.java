package com.ssafy.test.service;

import java.util.List;

import com.ssafy.test.dto.CountryStatus;

public interface CountryService {

	void insertCountryStatus(CountryStatus countryStatus);

	void deleteCountryStatus(String[] ccodeList);

	List<CountryStatus> selectCountryStatus();

	CountryStatus selectCountryStatusByCcode(String ccode);

}