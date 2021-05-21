package com.assessment.jumia.phonevalidator.service.PhoneValidator.countriesvalidations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.jumia.phonevalidator.dto.CustomerPhoneValidationDTO;
import com.assessment.jumia.phonevalidator.model.Customer;
import com.assessment.jumia.phonevalidator.model.PhoneValidationState;
import com.assessment.jumia.phonevalidator.util.PhoneValidatorUtil;

@Service
public class PhoneValidatorImpl implements PhoneValidator {
	
	@Autowired
	private PhoneValidatorUtil phoneValidatorUtil;
	
	@Override
	public void validatePhoneNumber(Customer customer, CustomerPhoneValidationDTO customerPhoneValidationDTO) {
			
			boolean isVerified =  phoneValidatorUtil.validatePhoneNumberRegex(customer.getPhone(),customerPhoneValidationDTO);
			if(isVerified)
				phoneValidatorUtil.updatePhoneValidationDTO(customer, customerPhoneValidationDTO,PhoneValidationState.VALID);
			
			else if(customerPhoneValidationDTO.getPhoneNumber() == null)
				phoneValidatorUtil.updatePhoneValidationDTO(customer, customerPhoneValidationDTO, PhoneValidationState.INVALID);
	
	}
	
}
