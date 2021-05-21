package com.assessment.jumia.phonevalidator.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import com.assessment.jumia.phonevalidator.model.PhoneValidationLookup;

@Component
public class DataPreparationUtil {
	
	public static Map<String, PhoneValidationLookup> PHONE_VALIDATION_DATA;
	
	
	
	@PostConstruct
	public void createMap() {
		PHONE_VALIDATION_DATA = new HashMap<>();
		List<PhoneValidationLookup> lookupValues = Arrays.asList(PhoneValidationLookup.values());
		lookupValues.stream().forEach(lookup -> PHONE_VALIDATION_DATA.put(lookup.getCountryCode().replace("+",""), lookup));
	}
	

}
