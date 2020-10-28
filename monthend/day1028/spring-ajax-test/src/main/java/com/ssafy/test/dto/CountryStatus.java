package com.ssafy.test.dto;

public class CountryStatus {
	 private String ccode;
	 private String cname;
	 private int patient;
	 private String rcode;
	 private String rname;
	 
	 public String getRname() {
		return rname;
	}


	public void setRname(String rname) {
		this.rname = rname;
	}


	public String getCcode() {
		return ccode;
	}


	public void setCcode(String ccode) {
		this.ccode = ccode;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public int getPatient() {
		return patient;
	}


	public void setPatient(int patient) {
		this.patient = patient;
	}


	public String getRcode() {
		return rcode;
	}


	public void setRcode(String rcode) {
		this.rcode = rcode;
	}


	@Override
	public String toString() {
		return "CountryStatus [ccode=" + ccode + ", cname=" + cname + ", patient=" + patient + ", rcode=" + rcode + "]";
	}
	 
	 
}
