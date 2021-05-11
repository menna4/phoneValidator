package com.assessment.jumia.phonevalidator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.jumia.phonevalidator.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	
}
