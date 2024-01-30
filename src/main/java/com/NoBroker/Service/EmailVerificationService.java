package com.NoBroker.Service;

import java.util.Map;

public interface EmailVerificationService {
    Map<String, String> verifyOtp(String email, String otp);


    Map<String, String> sendOtpForLogin(String email);
}
