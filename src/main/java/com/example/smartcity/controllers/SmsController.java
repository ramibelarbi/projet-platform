package com.example.smartcity.controllers;

import com.example.smartcity.sms.SmsRequest;
import com.example.smartcity.sms.SmsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")@AllArgsConstructor
public class SmsController {
    private final SmsService smsService;

    @PostMapping("/send/{num}")
    ResponseEntity<String> sendSms(@RequestBody String message, @PathVariable("num") String num){
        SmsRequest smsRequest = new SmsRequest(num,message);
        smsService.sendSms(smsRequest);
        return new ResponseEntity<>("Message envoye avec success", HttpStatus.OK);
    }
}
