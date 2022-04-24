package com.example.smartcity.services;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service("mailService") @AllArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;

    public void sendEmail(String reciver , String text) throws MessagingException {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setTo(reciver);
            helper.setText(text);
            helper.setSubject("Acces au document ");

            mailSender.send(message);
        }
    }


