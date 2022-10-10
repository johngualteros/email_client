package com.example.email_client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class EmailClientApplication {

    @Autowired
    private EmailSenderService emailService;

    public static void main(String[] args) {
        SpringApplication.run(EmailClientApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail(){
        emailService.sendSimpleEmail("mailForSend",
                                "this is a email body",
                                "this is a email subject");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMailWithAttachment() throws MessagingException {
        emailService.sendEmailWithAttachment("mailForSend",
                "this is a email body with attachment",
                "this is a email subject with attachment",
                "C:\\Users\\jumbo170\\Downloads\\example_svelte.png");
    }
}
