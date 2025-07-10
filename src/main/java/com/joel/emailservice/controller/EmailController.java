package com.joel.emailservice.controller;

import com.joel.emailservice.model.EmailRequest;
import com.joel.emailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // this means all routes here are prefixed with /api
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest request) {
        return emailService.sendEmail(request);
    }
}
