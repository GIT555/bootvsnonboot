package com.bnpp.pb.test;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.io.IOException;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

    @Autowired
	EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}


	public void run(String... args) {

		System.out.println("Sending Email...");

		try {

			sendEmail();
			//sendEmailWithAttachment();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");

	}

	void sendEmail() {

		/*SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("1@gmail.com", "2@yahoo.com");

		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");*/
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
