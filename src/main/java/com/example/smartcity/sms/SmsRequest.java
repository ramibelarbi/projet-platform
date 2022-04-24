package com.example.smartcity.sms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter @AllArgsConstructor
public class SmsRequest {
    private String number ;
    private String message;
}
