package com.ShoppingPlusBackend.ShoppingPlusBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoppingPlusBackend.ShoppingPlusBackend.Services.CustomerRepository;
import com.ShoppingPlusBackend.ShoppingPlusBackend.model.Customer;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository; // Assuming you have this repository

    public void createCustomer(String phoneNumber, String name, String addressLine1, String addressLine2, String city, String pinCode) {
        Customer customer = new Customer();
        customer.setPhoneNumber(phoneNumber);
        customer.setName(name);
        customer.setAddressLine1(addressLine1);
        customer.setAddressLine2(addressLine2);
        customer.setCity(city);
        customer.setPinCode(pinCode);

        customerRepository.save(customer);
    }
}
