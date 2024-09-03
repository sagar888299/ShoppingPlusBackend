package com.ShoppingPlusBackend.ShoppingPlusBackend.controller;

public class OTPRequest {
	  private String phoneNumber;
	  private String otp;
	  private String name;

	    public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		// Getter and Setter
	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }
}
