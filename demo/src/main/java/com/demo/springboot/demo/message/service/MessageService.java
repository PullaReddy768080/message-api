package com.demo.springboot.demo.message.service;

import com.demo.springboot.demo.message.entity.MessageEntity;
import com.demo.springboot.demo.message.model.Message;

import java.util.List;




public interface MessageService {



    public Message saveMessage(Message message);

    public Message saveMessage2(Message message);
    public Message readMessage(int id);

    public Message updateMessage(Message message);

    public String deleteMessage(Integer id);

    List<String> getSenderMessages(Integer senderId);

    List<MessageEntity> getReceiverDetails(Integer receiverId);


}
