package com.assessment.jumia.phonevalidator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import com.assessment.jumia.phonevalidator.dto.CustomerPhoneValidationDTO;
import com.assessment.jumia.phonevalidator.model.Customer;
import com.assessment.jumia.phonevalidator.model.PhoneValidationLookup;
import com.assessment.jumia.phonevalidator.model.PhoneValidationState;

@Component
public class PhoneValidatorUtil {
	
	public boolean validatePhoneNumberRegex(String cutomerPhoneNumber,CustomerPhoneValidationDTO customerPhoneValidationDTO) {
		String countryCode = getCountryCodeFromPhoneNumber(cutomerPhoneNumber);
		if(DataPreparationUtil.PHONE_VALIDATION_DATA.containsKey(countryCode )) {
			
			Pattern pattern = Pattern.compile(DataPreparationUtil.PHONE_VALIDATION_DATA.get(countryCode).getCountryPhoneRegex());
		    Matcher matcher = pattern.matcher(cutomerPhoneNumber);
		    return matcher.matches();
		} else {
			return false;
		}
		
	}

	public void updatePhoneValidationDTO(Customer customer, CustomerPhoneValidationDTO customerPhoneValidationDTO, PhoneValidationState phoneValidationState) {


		PhoneValidationLookup lookup = DataPreparationUtil.PHONE_VALIDATION_DATA.get(getCountryCodeFromPhoneNumber(customer.getPhone()));
		if(lookup != null) {

			customerPhoneValidationDTO.setCountry(lookup.getCountry());
			customerPhoneValidationDTO.setCountryCode(lookup.getCountryCode());
		}
		customerPhoneValidationDTO.setId(customer.getId());
		customerPhoneValidationDTO.setCustomerName(customer.getName());
		customerPhoneValidationDTO.setPhoneNumber(customer.getPhone());
		customerPhoneValidationDTO.setPhoneValidationState(phoneValidationState);
		
		
	}
	
	private String getCountryCodeFromPhoneNumber(String phoneNumber) {
		String trimmedCode = phoneNumber.substring(phoneNumber.indexOf("(")+1, phoneNumber.indexOf(")"));
		return trimmedCode;
	}
}
