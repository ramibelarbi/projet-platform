package com.example.smartcity.exceptions;

public class PersonneNotFoundException extends RuntimeException {
    public PersonneNotFoundException(String message) {
        super(message);
    }
}
