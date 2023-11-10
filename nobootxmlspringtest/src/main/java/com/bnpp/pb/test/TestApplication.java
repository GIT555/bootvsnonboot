package com.bnpp.pb.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.io.IOException;

//@SpringBootApplication
public class TestApplication  {

    @Autowired
	EmailService emailService;

	public static void main(String[] args) {



		System.out.println("Sending Email...");


		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appContext.xml");
		EmailService emailService=applicationContext.getBean(EmailService.class);
try {
	//javaMailSender.send(msg);

	EmailDetails emailDetails=new EmailDetails();
	emailDetails.setRecipient("ismail.shk@gmail.com");
	emailDetails.setSubject("Hello");
	emailDetails.setMsgBody("Body");
	String s = emailService.sendSimpleMail(emailDetails);
}
catch(Exception e){
	e.printStackTrace();
}

	}
	/*@Autowired
	private JavaMailSender javaMailSender;*/
}
