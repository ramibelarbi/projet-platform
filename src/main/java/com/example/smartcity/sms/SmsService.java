package com.example.smartcity.sms;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Service @AllArgsConstructor
public class SmsService {
    private final TwilioProperties twilioProperties;

    //send message to number
    public String sendSms(SmsRequest smsRequest)
    {
        Message message=Message.creator(new PhoneNumber(smsRequest.getNumber()), new PhoneNumber(twilioProperties.getFromNumber()), smsRequest.getMessage()).create();
        return message.getStatus().toString();
    }
}
