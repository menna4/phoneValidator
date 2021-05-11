package com.assessment.jumia.phonevalidator.service;

import java.util.List;

import com.assessment.jumia.phonevalidator.dto.CustomerPhoneValidationDTO;

public interface CustomerPhoneNumberValidatorService {

	List<CustomerPhoneValidationDTO> getAllCustomers();
}
