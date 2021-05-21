package com.assessment.jumia.phonevalidator.model;

public enum PhoneValidationLookup {

	CAMEROON("+237","\\(237\\)\\ ?[2368]\\d{7,8}$","Cameroon"),
	ETHIOPIA("+251", "\\(251\\)\\ ?[1-59]\\d{8}$","Ethiopia"),
	MOROCCO("+212", "\\(212\\)\\ ?[5-9]\\d{8}$","Morocco"),
	MOZAMBIQUE("+258", "\\(258\\)\\ ?[28]\\d{7,8}$","Mozambique"),
	UGANDA("+256"," \\(256\\)\\ ?\\d{9}$","Uganda");
	
	private String countryCode;
	
	private String countryPhoneRegex;
	
	private String country;
	
	
	
	private PhoneValidationLookup (String countryCode , String countryPhoneRegex, String country){
		this.countryCode = countryCode;
		this.countryPhoneRegex = countryPhoneRegex;
		this.country = country;
	}



	public String getCountryCode() {
		return countryCode;
	}




	public String getCountryPhoneRegex() {
		return countryPhoneRegex;
	}



	public String getCountry() {
		return country;
	}

	
	
}
