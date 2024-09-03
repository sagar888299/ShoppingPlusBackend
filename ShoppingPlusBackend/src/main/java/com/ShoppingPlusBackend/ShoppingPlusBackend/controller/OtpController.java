package com.ShoppingPlusBackend.ShoppingPlusBackend.controller;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ShoppingPlusBackend.ShoppingPlusBackend.Services.CustomerRepository;
import com.ShoppingPlusBackend.ShoppingPlusBackend.Services.OTPService;
import com.ShoppingPlusBackend.ShoppingPlusBackend.model.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "https://shopping-plus-frontend.vercel.app")
@RestController
@RequestMapping("/api/otp")
public class OtpController {

    @Autowired
    private OTPService otpService;

  
	@Autowired
    private CustomerRepository customerRepository;
	
	@GetMapping("/customer")
	public List<Customer> getAllEmployees(){
		return customerRepository.findAll();
	}		
    

    private final Map<String, String> otpData = new HashMap<>();

    @PostMapping("/send")
    public String sendOTP(@RequestBody OTPRequest otpRequest) {
    	  String phoneNumber = otpRequest.getPhoneNumber();
        String otp = otpService.generateOTP();
        otpData.put(phoneNumber, otp);
        otpService.sendOTP(phoneNumber, otp);
        return "OTP sent to " + phoneNumber;
    }

    @PostMapping("/verify")
    public ResponseEntity<VerifyOTPResponse> verifyOTP(@RequestBody OTPRequest otpRequest) {
        String phoneNumber = otpRequest.getPhoneNumber();
        String otp = otpRequest.getOtp();
        String name = otpRequest.getName();

        String savedOtp = otpData.get(phoneNumber);

        if (savedOtp != null && savedOtp.equals(otp)) {
            otpData.remove(phoneNumber); // Remove OTP once it's verified

            // Create or update customer
            Customer customer = customerRepository.findById(phoneNumber)
                    .orElseGet(() -> new Customer(phoneNumber, name)); // Create new if not exists

            if (customer.getName() == null) {
                customer.setName(name); // Update name if not set
            }

            customerRepository.save(customer); // Save the customer

            // Return the customer in the response body
            return ResponseEntity.ok(new VerifyOTPResponse(customer));
        } else {
            // Return an error message in the response body
            return ResponseEntity.status(HttpStatus.SC_UNAUTHORIZED).body(new VerifyOTPResponse("Invalid OTP!"));
        }
    }

}

