package com.ShoppingPlusBackend.ShoppingPlusBackend.controller;

import com.ShoppingPlusBackend.ShoppingPlusBackend.model.Customer;

public class VerifyOTPResponse {
    private Customer customer;
    private String message;

    // Constructors
    public VerifyOTPResponse(Customer customer) {
        this.customer = customer;
    }

    public VerifyOTPResponse(String message) {
        this.message = message;
    }

    // Getters and Setters
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
