package com.assessment.jumia.phonevalidator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.jumia.phonevalidator.dto.CustomerPhoneValidationDTO;
import com.assessment.jumia.phonevalidator.model.Customer;
import com.assessment.jumia.phonevalidator.repository.CustomerRepository;
import com.assessment.jumia.phonevalidator.service.PhoneValidator.countriesvalidations.PhoneValidator;

@Service
public class CustomerPhoneNumberValidatorServiceImpl implements CustomerPhoneNumberValidatorService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PhoneValidator phoneValidator;
	
	@Override
	public List<CustomerPhoneValidationDTO> getAllCustomers() {
		
		List<CustomerPhoneValidationDTO> customerPhoneValidationDTOs = new ArrayList<>();

		List<Customer> customers = customerRepository.findAll();
		
		if(customers != null && customers.size() > 0) {
			for (Customer customer : customers) {
				if(customer.getPhone() != null && ! customer.getPhone().isEmpty()) {
				CustomerPhoneValidationDTO customerPhoneValidationDTO = new CustomerPhoneValidationDTO();
					phoneValidator.validatePhoneNumber(customer, customerPhoneValidationDTO);
					customerPhoneValidationDTOs.add(customerPhoneValidationDTO);
				}
			}
		}
		return customerPhoneValidationDTOs;
	}
	
	

}
