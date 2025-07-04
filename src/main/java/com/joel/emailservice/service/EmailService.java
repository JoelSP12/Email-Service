package com.joel.emailservice.service;

import com.joel.emailservice.model.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    private final String toEmail = "joelshiyam1122@gmail.com";

    public String sendEmail(EmailRequest request) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(toEmail);
            message.setSubject("New Contact Form Submission");

            String body = "You received a new message from your portfolio:\n\n"
                    + "Name: " + request.getName() + "\n"
                    + "Email: " + request.getEmail() + "\n"
                    + "Message:\n" + request.getMessage();

            message.setText(body);
            message.setFrom("joelshiyam1122@gmail.com");

            mailSender.send(message);
            return "Email sent successfully!";
        } catch (Exception e) {
            return "Error sending email: " + e.getMessage();
        }
    }
}
