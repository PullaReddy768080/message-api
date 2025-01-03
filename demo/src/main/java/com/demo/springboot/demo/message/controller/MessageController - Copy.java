package com.demo.springboot.demo.message.controller;

import com.demo.springboot.demo.message.entity.MessageEntity;
import com.demo.springboot.demo.message.model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface MessageController

{
    @PostMapping("/post/message")
    public ResponseEntity<Message> saveMessage(@RequestBody Message message);


    @PostMapping ("/post/message2") // here we can write as we like (/save/message)
    public ResponseEntity<Message> saveMessage2(@RequestBody Message message);


    @GetMapping("/get/message/{id}")
    @ResponseBody
    public ResponseEntity<Message> readMessage(@PathVariable("id") Integer id);


    @PutMapping("/update/message")
    public ResponseEntity<Message> updateMessage(@RequestBody Message message);


    @DeleteMapping("/delete/message/{id}")
    public  ResponseEntity<String> deleteMessage(@PathVariable("id") Integer id);

    @GetMapping("/get/sender/{senderId}")
    public ResponseEntity<List<String>> getSenderMessages(@PathVariable("senderId") Integer senderId);


    @GetMapping("/get/receiver/{receiverId}")
    public ResponseEntity<List<MessageEntity>> getReceiverDetails(@PathVariable("receiverId") Integer receiverId);


}
