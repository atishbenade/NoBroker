package com.NoBroker.Service.ServiceImpl;

import com.NoBroker.Service.EmailService;
import com.NoBroker.Service.EmailVerificationService;
import com.NoBroker.Service.UserService;
import com.NoBroker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailVerificationServiceImpl implements EmailVerificationService {
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;
    static final Map<String,String>emailOtpMapping=new HashMap<>();

    @Override
    public Map<String, String> verifyOtp(String email, String otp) {
        String storedOtp = emailOtpMapping.get(email);//heare (email) is key word of the value. we used variable of hash map above mentioned

         Map<String,String >response=new HashMap<>();//this hashmap was created to send response

         if (storedOtp!=null&&storedOtp.equals(otp)){
               User user = userService.getUserByEmail(email);
               userService.verifyEmail(user);
               emailOtpMapping.remove(email);
               response.put("status","sucess");
               response.put("message","otp verified successfully");

           }else {
             
               response.put("status","error");
               response.put("message","invalid otp");
           }

           return response;
    }

    @Override
    public Map<String, String> sendOtpForLogin(String email) {
        if (userService.isEmailVerified(email)){
            Map<String, String> map = emailService.sendOtpEmail(email);
            return map;

        }else {
            userService.deleteByEmail(email);
            Map<String,String> response= new HashMap<>();
            response.put("status","error");
            response.put("message","email is not verified");
            return response;
        }



    }
}
