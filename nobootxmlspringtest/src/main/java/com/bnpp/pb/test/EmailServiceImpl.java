package com.bnpp.pb.test;


// Java Program to Illustrate Creation Of
// Service implementation class


// Importing required classes



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

// Annotation
@Service
// Class
// Implementing EmailService interface
public class EmailServiceImpl implements EmailService {

    private JavaMailSenderImpl javaMailSender;

    public JavaMailSenderImpl getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Value("${ism.mail.username}") private String sender;

    // Method 1
    // To send a simple email
    public String sendSimpleMail(EmailDetails details)
    {

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());
            Properties prop=javaMailSender.getJavaMailProperties();

            System.out.println("==================MailProps===========");
            prop.stringPropertyNames().stream()
                    .map(key -> key + ": " + prop.getProperty(key))
                    .forEach(System.out::println);

            System.out.println("==================MailProps===========");
            Properties allprop=System.getProperties();
            allprop.stringPropertyNames().stream()
                    .map(key -> key + ": " + allprop.getProperty(key))
                    .forEach(System.out::println);


            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            e.printStackTrace();
            return "Error while Sending Mail";
        }
    }

    // Method 2
    // To send an email with attachment

}