package com.assessment.jumia.phonevalidator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.jumia.phonevalidator.dto.CustomerPhoneValidationDTO;
import com.assessment.jumia.phonevalidator.service.CustomerPhoneNumberValidatorService;

@CrossOrigin
@RestController
public class CustomerPhoneValidationController {
	
	@Autowired
	private CustomerPhoneNumberValidatorService customerPhoneNumberValidatorService;

	@GetMapping(value = "/customers")
	public List<CustomerPhoneValidationDTO> getCallDisplayDetailsDTO() {

		return customerPhoneNumberValidatorService.getAllCustomers();
	}
}
