package com.ShoppingPlusBackend.ShoppingPlusBackend.Services;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OTPService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String fromNumber;

    private final Random random = new Random();

    // Store OTP with its expiration time
    private final Map<String, OTPDetails> otpStorage = new HashMap<>();

    @PostConstruct
    public void init() {
        Twilio.init(accountSid, authToken);
    }

    // Class to hold OTP and its expiration time
    private static class OTPDetails {
        private final String otp;
        private final LocalDateTime expirationTime;

        OTPDetails(String otp, LocalDateTime expirationTime) {
            this.otp = otp;
            this.expirationTime = expirationTime;
        }

        public String getOtp() {
            return otp;
        }

        public LocalDateTime getExpirationTime() {
            return expirationTime;
        }
    }

    /**
     * Generates a 6-digit OTP.
     *
     * @return A 6-digit OTP as a String.
     */
    public String generateOTP() {
        return String.format("%06d", random.nextInt(999999));
    }

    /**
     * Sends the generated OTP to the specified phone number using Twilio and stores it with a 2-minute expiration time.
     *
     * @param toPhoneNumber The recipient's phone number.
     * @param otp The OTP to be sent.
     */
    public void sendOTP(String toPhoneNumber, String otp) {
        LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(2);
        otpStorage.put(toPhoneNumber, new OTPDetails(otp, expirationTime));

        Message.creator(
                new PhoneNumber(toPhoneNumber),
                new PhoneNumber(fromNumber),
                "Your OTP is: " + otp + ". It is valid for 2 minutes."
        ).create();
    }

    /**
     * Validates the provided OTP against the stored OTP and checks if it is expired.
     *
     * @param phoneNumber The phone number to validate the OTP against.
     * @param otp The OTP to validate.
     * @return True if the OTP is valid and not expired, false otherwise.
     */
    public boolean validateOTP(String phoneNumber, String otp) {
        OTPDetails otpDetails = otpStorage.get(phoneNumber);

        if (otpDetails != null) {
            if (LocalDateTime.now().isBefore(otpDetails.getExpirationTime()) && otpDetails.getOtp().equals(otp)) {
                otpStorage.remove(phoneNumber);  // Clear OTP after successful validation
                return true;
            } else {
                otpStorage.remove(phoneNumber);  // OTP is expired or incorrect, remove it
            }
        }

        return false;
    }

    /**
     * Optional: Clean up OTPs that are expired periodically.
     */
    public void cleanupExpiredOtps() {
        otpStorage.entrySet().removeIf(entry -> LocalDateTime.now().isAfter(entry.getValue().getExpirationTime()));
    }
}
