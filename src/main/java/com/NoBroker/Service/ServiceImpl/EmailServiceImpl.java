package com.NoBroker.Service.ServiceImpl;

import com.NoBroker.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.NoBroker.Service.ServiceImpl.EmailVerificationServiceImpl.emailOtpMapping;

@Service
public class EmailServiceImpl implements EmailService {


    @Autowired
    private JavaMailSender javaMailSender;



    public String generateOtp(){
        return String.format("%06d",new java.util.Random().nextInt(1000000));
            }
        @Override
        public Map<String, String> sendOtpEmail(String email){
        String otp = generateOtp();
        emailOtpMapping.put(email,otp);
        sendEmail(email,"otp for Verification","your otp is"+otp);

        Map<String,String> response= new HashMap<>();
        response.put("status","success");
        response.put("message","otp sent successfully");
        return response;

    }
    public void sendEmail(String to,String subject,String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
    }


}
