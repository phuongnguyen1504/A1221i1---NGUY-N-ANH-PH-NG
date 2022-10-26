package com.demo.controller;

import com.demo.model.EmailDetails;
import com.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired private EmailService emailService;
    // Sending a simple Email
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    //Code API chạy test
    //{
    //    "recipent":"abc@gmail.com",
    //    "msgBody":"Hello This is mail text simple \n Thanks \n <img src=\"https://howtovietnamese.com/static/c14e9af89a31156da4e0de35fe446d9e/db955/blog-hello-in-vietnamese.png\">",
    //    "subject":"Day la mail don gian chi co text"
    //
    //}

    @PostMapping(value = "/sendMail")
    public String sendMail(@RequestBody EmailDetails emailDetails){
        String status=emailService.sendSimpleMail(emailDetails);
        return status;
    }

//    {
//        "recipent":"abc@gmail.com",
//            "msgBody":"Hello This is mail text simple \n Thanks \n <img src=\"https://howtovietnamese.com/static/c14e9af89a31156da4e0de35fe446d9e/db955/blog-hello-in-vietnamese.png\">",
//            "subject":"Day la mail don gian dinh kem file",
//            "attachment":"C:/Users/ADMIN/Downloads/Capture.PNG", iihrxqehwoguakiq
//
//    }
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(@RequestBody EmailDetails details){
        String status=emailService.sendMailWithAttachment(details);
        return status;
    }
}
