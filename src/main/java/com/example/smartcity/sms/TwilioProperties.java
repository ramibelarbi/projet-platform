package com.example.smartcity.sms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration @Getter @NoArgsConstructor
public class TwilioProperties {
    private String accountSid = "ACcbfd6c4de0a4e3a0463bc1da279d122f";
    private String authToken = "0bebd63bd65873ecb47c21720e641601";
    private String fromNumber = "+19123725431";
}
