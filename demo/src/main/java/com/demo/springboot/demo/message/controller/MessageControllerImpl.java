package com.demo.springboot.demo.message.controller;

import com.demo.springboot.demo.message.entity.MessageEntity;
import com.demo.springboot.demo.message.model.Message;
import com.demo.springboot.demo.message.service.MessageServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageControllerImpl implements MessageController{
    @Autowired
    private MessageServiceImplement messageService; // creating an object using autowired annotation



    public ResponseEntity<Message> saveMessage(@RequestBody Message message){
        return new ResponseEntity<>(messageService.saveMessage(message), HttpStatusCode.valueOf(200));

    }





    public ResponseEntity<Message> saveMessage2(@RequestBody Message message){
        return new ResponseEntity<>(messageService.saveMessage2(message), HttpStatusCode.valueOf(200));

    }


    public ResponseEntity<Message> readMessage(@PathVariable("id") Integer id)
    {
        return new ResponseEntity<>(messageService.readMessage(id), HttpStatusCode.valueOf(200));
    }



    public ResponseEntity<Message> updateMessage(@RequestBody Message message) {
        return new ResponseEntity<>(messageService.updateMessage(message), HttpStatusCode.valueOf(200));
    }





    public  ResponseEntity<String> deleteMessage(@PathVariable("id") Integer id) {
        String result = messageService.deleteMessage(id);
        if ("Item is deleted successfully".equals(result)) {
            return ResponseEntity.ok(result); // Return 200 OK with success message
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result); // Return 404 with error message
        }
    }




    @Override
    public ResponseEntity<List<String>> getSenderMessages(Integer senderId) {
        return new ResponseEntity<>(messageService.getSenderMessages(senderId), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<List<MessageEntity>> getReceiverDetails(Integer receiverId) {
        return new ResponseEntity<>(messageService.getReceiverDetails(receiverId), HttpStatus.OK);
    }











}

