package com.ShoppingPlusBackend.ShoppingPlusBackend.Services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ShoppingPlusBackend.ShoppingPlusBackend.model.Customer;



public interface CustomerRepository extends JpaRepository<Customer, String> {

	
	
}
