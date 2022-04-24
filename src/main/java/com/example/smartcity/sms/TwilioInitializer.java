package com.example.smartcity.sms;

import com.twilio.Twilio;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInitializer {
    private final TwilioProperties twilioProperties;

    public TwilioInitializer(TwilioProperties twilioProperties)
    {
        this.twilioProperties=twilioProperties;
        Twilio.init(twilioProperties.getAccountSid(), twilioProperties.getAuthToken());
        System.out.println("twilio initialized with account: "+twilioProperties.getAccountSid());
    }
}
