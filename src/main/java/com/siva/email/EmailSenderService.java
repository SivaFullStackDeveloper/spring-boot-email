package com.siva.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender javaMailSender;

    public boolean sendEmail(String toEmail,String  subject,String body){
       try{

           SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
           simpleMailMessage.setFrom("sivasivacoa@gmail.com");
           simpleMailMessage.setTo(toEmail);
           simpleMailMessage.setSubject(subject);
           simpleMailMessage.setText(body);
           javaMailSender.send(simpleMailMessage);
           return true;
       } catch (Exception e) {

           System.out.println(e.toString());
           return false;
       }

    }
}
