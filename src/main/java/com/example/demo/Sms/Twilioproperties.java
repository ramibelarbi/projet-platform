package com.example.demo.Sms;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Twilioproperties {
	private String accountSid = "ACcbfd6c4de0a4e3a0463bc1da279d122f";
	private String authToken = "18f1bb7dac3fe3c9b69d223dcb2f4ae8";
	private String fromNumber = "+19123725431";
	public String getAccountSid() {
		return accountSid;
	}
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getFromNumber() {
		return fromNumber;
	}
	public void setFromNumber(String fromNumber) {
		this.fromNumber = fromNumber;
	}
	public Twilioproperties() {
		super();
		// TODO Auto-generated constructor stub
	}


}
