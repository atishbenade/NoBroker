package com.NoBroker.controller;

import com.NoBroker.Service.EmailService;
import com.NoBroker.Service.EmailVerificationService;
import com.NoBroker.Service.UserService;
import com.NoBroker.payload.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ResistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private EmailVerificationService emailVerificationService;



    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto){
        UserDto user = userService.registerUser(userDto);
        Map<String, String> message = emailService.sendOtpEmail(userDto.getEmail());
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestParam String email,@RequestParam String otp){
        Map<String, String> map = emailVerificationService.verifyOtp(email, otp);
        return new ResponseEntity<>(map,HttpStatus.CREATED);
    }






}
