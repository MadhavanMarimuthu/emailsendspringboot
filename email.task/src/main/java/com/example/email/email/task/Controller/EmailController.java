package com.example.email.email.task.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.email.email.task.EmailService.EmailService;
import com.example.email.email.task.Entityclass.EmailEntity;

@RestController
@RequestMapping("/EmailController")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	@PostMapping(value = "post")
	private void email(@RequestBody EmailEntity emailEntity ) throws Exception {
		 SimpleMailMessage message = new SimpleMailMessage();
		String sendto= emailEntity.getSendto();
		String subject= emailEntity.getSubject();
		String  text=emailEntity.getText();
		emailService.sendSimpleEmail(sendto, subject, text);
		
		
	}
	

}
