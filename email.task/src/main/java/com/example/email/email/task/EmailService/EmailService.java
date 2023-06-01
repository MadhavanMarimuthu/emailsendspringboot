package com.example.email.email.task.EmailService;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.email.email.task.Entityclass.EmailEntity;

import jakarta.mail.internet.MimeMessage;
@Service
public class EmailService {
    private final JavaMailSender mailSender;

  
 
    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;

    }
  
 
 
    public void sendSimpleEmail(String toEmail,
                                String body,
                                String subject) {
        SimpleMailMessage message = new SimpleMailMessage();
 
        message.setFrom("mailId@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
 
        mailSender.send(message);
        System.out.println("Mail Send...");
    }
 
  
}


