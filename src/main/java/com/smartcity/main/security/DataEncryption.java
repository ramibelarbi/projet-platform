package com.smartcity.main.security;


import org.jasypt.util.text.BasicTextEncryptor;

public class DataEncryption {
    BasicTextEncryptor textEncryptor = new BasicTextEncryptor();


    public String Encrypt(String text) {
        textEncryptor.setPassword("nejah");
         return  textEncryptor.encrypt(text);
    }
    public String Decrypt(String text) {
        textEncryptor.setPassword("nejah");
        return  textEncryptor.decrypt(text);
    }
}
