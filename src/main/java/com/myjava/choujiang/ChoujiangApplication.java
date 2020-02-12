package com.myjava.choujiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.io.IOException;

@SpringBootApplication

@ServletComponentScan()
public class ChoujiangApplication {

    public static void login(){
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080/insert");
        } catch (IOException e) {
        }
    }
    public static void main(String[] args) {
        SpringApplication.run(ChoujiangApplication.class, args);
        login();
    }
}
