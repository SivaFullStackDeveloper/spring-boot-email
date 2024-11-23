package com.siva.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EmailController {
    @Autowired
    private EmailSenderService emailSenderService;
    @PostMapping("/sendEmail")
    public ResponseEntity<?>sendEmail(@RequestParam String toEmail,@RequestParam String body,@RequestParam String subject) {
       boolean sent =  emailSenderService.sendEmail(toEmail,subject,body);
       return new ResponseEntity<>(sent, HttpStatus.OK);
    }
}
