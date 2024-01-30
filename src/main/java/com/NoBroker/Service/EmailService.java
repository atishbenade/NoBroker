package com.NoBroker.Service;

import java.util.Map;

public interface EmailService {
    Map<String, String> sendOtpEmail(String email);
}
