package com.assessment.jumia.phonevalidator.service.PhoneValidator.countriesvalidations;

import com.assessment.jumia.phonevalidator.dto.CustomerPhoneValidationDTO;
import com.assessment.jumia.phonevalidator.model.Customer;

public interface PhoneValidator  {
	
	void validatePhoneNumber(Customer customer, CustomerPhoneValidationDTO customerPhoneValidationDTO);
	
	

}
