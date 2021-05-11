package com.assessment.jumia.phonevalidator.dto;

import java.io.Serializable;

import com.assessment.jumia.phonevalidator.model.PhoneValidationState;

public class CustomerPhoneValidationDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String customerName;
	
	private String phoneNumber;
	
	private String country;
	
	private String countryCode;
	
	private PhoneValidationState phoneValidationState = PhoneValidationState.INVALID;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public PhoneValidationState getPhoneValidationState() {
		return phoneValidationState;
	}

	public void setPhoneValidationState(PhoneValidationState phoneValidationState) {
		this.phoneValidationState = phoneValidationState;
	}
	

}
