package com.smartcity.main.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;

@Service("mailService")
public class MailServiceImpl {

    @Autowired
    JavaMailSender mailSender;

    public void sendEmail(String reciver , String text) throws MessagingException {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setTo(reciver);
            helper.setText(text);
            helper.setSubject("Hi");

            mailSender.send(message);
        }
    }


