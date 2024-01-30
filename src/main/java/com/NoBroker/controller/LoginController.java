package com.NoBroker.controller;

import com.NoBroker.Service.EmailVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private EmailVerificationService emailVerificationService;

    @PostMapping("/send_otp_for_login")
    public ResponseEntity<Map<String,String>>sendOtpForLogin(@RequestParam String email){
        Map<String, String> map = emailVerificationService.sendOtpForLogin(email);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @PostMapping("/verify_otp_for_login")
    public ResponseEntity<Map<String,String>>verifyOtpForLogin(@RequestParam String email,@RequestParam String otp){
        Map<String, String> map = emailVerificationService.verifyOtp(email, otp);
        return new ResponseEntity<>(map,HttpStatus.ACCEPTED);
    }





}
