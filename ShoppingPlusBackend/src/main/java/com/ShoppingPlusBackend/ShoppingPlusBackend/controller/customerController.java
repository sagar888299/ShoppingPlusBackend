package com.ShoppingPlusBackend.ShoppingPlusBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ShoppingPlusBackend.ShoppingPlusBackend.Services.CustomerRepository;
import com.ShoppingPlusBackend.ShoppingPlusBackend.model.Customer;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/customers")
public class customerController {

    @Autowired
    private CustomerRepository customerRepository;

    // Update customer details (partial updates)
    @PatchMapping("/{phoneNumber}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String phoneNumber, @RequestBody Customer updatedCustomer) {
        // Find customer by phone number
        Optional<Customer> existingCustomerOptional = customerRepository.findById(phoneNumber);

        if (existingCustomerOptional.isPresent()) {
            Customer existingCustomer = existingCustomerOptional.get();

            // Update the existing customer details only if they are not null in the request body
            if (updatedCustomer.getName() != null) {
                existingCustomer.setName(updatedCustomer.getName());
            }
            if (updatedCustomer.getAddressLine1() != null) {
                existingCustomer.setAddressLine1(updatedCustomer.getAddressLine1());
            }
            if (updatedCustomer.getGender() != null) {
                existingCustomer.setGender(updatedCustomer.getGender());
            }
            if (updatedCustomer.getAddressLine2() != null) {
                existingCustomer.setAddressLine2(updatedCustomer.getAddressLine2());
            }
            if (updatedCustomer.getCity() != null) {
                existingCustomer.setCity(updatedCustomer.getCity());
            }
            if (updatedCustomer.getState() != null) {
                existingCustomer.setState(updatedCustomer.getState());
            }
            if (updatedCustomer.getEmail() != null) {
                existingCustomer.setEmail(updatedCustomer.getEmail());
            }
            if (updatedCustomer.getLocality() != null) {
                existingCustomer.setLocality(updatedCustomer.getLocality());
            }
            if (updatedCustomer.getImage() != null) {
                existingCustomer.setImage(updatedCustomer.getImage());
            }
            if (updatedCustomer.getPinCode() != null) {
                existingCustomer.setPinCode(updatedCustomer.getPinCode());
            }

            // Save the updated customer back to the repository
            Customer savedCustomer = customerRepository.save(existingCustomer);

            // Return the updated customer
            return ResponseEntity.ok(savedCustomer);
        } else {
            // Return 404 Not Found if the customer doesn't exist
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/{phoneNumber}")
    public ResponseEntity<Customer> getCustomerByPhoneNumber(@PathVariable String phoneNumber) {
        // Find customer by phone number
        Optional<Customer> customerOptional = customerRepository.findById(phoneNumber);

        if (customerOptional.isPresent()) {
            // Return the customer details if found
            return ResponseEntity.ok(customerOptional.get());
        } else {
            // Return 404 Not Found if the customer doesn't exist
            return ResponseEntity.notFound().build();
        }
    }
    
}
