package com.demo.springboot.demo.message.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //first

    @GetMapping ("/get/helloworld")

    @ResponseBody
    public String getHelloWorld(){
        return "HelloWorld Hi";
    }

    //second

    @GetMapping ("/get/greeting")

    @ResponseBody
    public String getGreeting(){
        return "Thank you";
    }







}
