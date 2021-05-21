package com.assessment.jumia.phonevalidator;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import com.assessment.jumia.phonevalidator.dto.CustomerPhoneValidationDTO;
import com.assessment.jumia.phonevalidator.model.Customer;
import com.assessment.jumia.phonevalidator.model.PhoneValidationLookup;
import com.assessment.jumia.phonevalidator.model.PhoneValidationState;
import com.assessment.jumia.phonevalidator.repository.CustomerRepository;
import com.assessment.jumia.phonevalidator.service.CustomerPhoneNumberValidatorService;
import com.assessment.jumia.phonevalidator.service.CustomerPhoneNumberValidatorServiceImpl;
import com.assessment.jumia.phonevalidator.service.PhoneValidator.countriesvalidations.PhoneValidator;
import com.assessment.jumia.phonevalidator.service.PhoneValidator.countriesvalidations.PhoneValidatorImpl;
import com.assessment.jumia.phonevalidator.util.DataPreparationUtil;
import com.assessment.jumia.phonevalidator.util.PhoneValidatorUtil;

@SpringBootTest
public class PhonevalidatorApplicationTests {

	final static String VALID_PHONE_NUMBER_AND_COUNTRY_CODE = "(237) 697151594";

	final static String INVALID_PHONE_NUMBER_AND_VALID_COUNTRY_CODE = "(237) 69715159469874";

	final static String VALID_PHONE_NUMBER_AND_INVALID_COUNTRY_CODE = "(264) 697151594";

	@Mock
	private CustomerRepository customerRepository;

	@InjectMocks
	CustomerPhoneNumberValidatorService customerPhoneNumberValidatorService = new CustomerPhoneNumberValidatorServiceImpl();

	@InjectMocks
	PhoneValidator phoneValidator = new PhoneValidatorImpl();

	@Spy
	private PhoneValidatorUtil phoneValidatorUtil;

	@Spy
	private DataPreparationUtil dataPreparationUtil;

	CustomerPhoneValidationDTO customerDTO;

	private List<Customer> customers = new ArrayList<>();

	@BeforeEach
	void setUpData() {

		mockCustomerData();

		mockValidationDataMap();

	}

	@Test
	void validateNoExceptionIsThrownWhenPhoneNumberIsEmpty() {

		doReturn(customers).when(customerRepository).findAll();
		
		customers.get(0).setPhone("");
		assertThatNoException().isThrownBy(() -> customerPhoneNumberValidatorService.getAllCustomers());
		System.out.println(customerPhoneNumberValidatorService.getAllCustomers());

	}

	@Test
	void validateStateIsValidIfPhoneNumberAndCountryCodeAreValid() {
		customers.get(0).setPhone(VALID_PHONE_NUMBER_AND_COUNTRY_CODE);
		phoneValidator.validatePhoneNumber(customers.get(0), customerDTO);
		Assertions.assertEquals(PhoneValidationState.VALID, customerDTO.getPhoneValidationState());
	}

	@Test
	void validateStateIsInValidIfPhoneNumberInvalidAndCountryCodeIsValid() {
		customers.get(0).setPhone(INVALID_PHONE_NUMBER_AND_VALID_COUNTRY_CODE);
		phoneValidator.validatePhoneNumber(customers.get(0), customerDTO);
		Assertions.assertEquals(PhoneValidationState.INVALID, customerDTO.getPhoneValidationState());
	}

	@Test
	void validateStateIsInValidIfPhoneNumberValidAndCountryCodeIsInValid() {
		customers.get(0).setPhone(VALID_PHONE_NUMBER_AND_INVALID_COUNTRY_CODE);
		phoneValidator.validatePhoneNumber(customers.get(0), customerDTO);
		Assertions.assertEquals(PhoneValidationState.INVALID, customerDTO.getPhoneValidationState());
	}

	private void mockCustomerData() {

		Customer customer = new Customer();
		customerDTO = new CustomerPhoneValidationDTO();

		customer.setId(1);
		customer.setName("Customer1");
		customers.add(customer);

	}

	private void mockValidationDataMap() {
		Map<String, PhoneValidationLookup> phoneValidationMap = new HashMap<>();
		phoneValidationMap.put("237", PhoneValidationLookup.CAMEROON);

		dataPreparationUtil.createMap();
	}


}
