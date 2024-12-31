package com.demo.springboot.demo.message.service;

import com.demo.springboot.demo.message.entity.MessageEntity;
import com.demo.springboot.demo.message.model.Message;
import com.demo.springboot.demo.message.repository.MessageRepository;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImplement implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private Environment environment;


    // it is not connected with database as we are not saving to Repository.
    public Message saveMessage(Message message) {
        return message;
    }


    public Message saveMessage2(Message message) {

        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setId(message.getId());
        messageEntity.setMessage(message.getMessage());
        messageEntity.setSenderId(message.getSenderId());
        messageEntity.setReceiverId(message.getReceiverId());
        messageRepository.save(messageEntity); //here save method is predefined
        return message;
    }

    public Message readMessage(int id)
    {

       MessageEntity messageEntity=messageRepository.findById(id).get();
        Message message=new Message();
        message.setId(messageEntity.getId());
        message.setMessage(messageEntity.getMessage());
        message.setSenderId(messageEntity.getSenderId());
        message.setReceiverId(messageEntity.getReceiverId());

        return message;


        //2nd method

        /*Optional<MessageEntity> messageEntityOptional=messageRepository.findById(id);

        if(messageEntityOptional.isEmpty()){
            return new Message();
        }
        else{


        Message message=new Message();
        message.setId(messageEntityOptional.get().getId());
        message.setMessage(messageEntityOptional.get().getMessage());
        message.setSenderId(messageEntityOptional.get().getSenderId());
        message.setReceiverId(messageEntityOptional.get().getReceiverId());
        return message;
        }*/

    }

    public Message updateMessage(Message message) {

        // Retrieve the existing message entity by ID

        //Using the throw is best practice instead of get()
        MessageEntity messageEntity = messageRepository.findById(message.getId()).orElseThrow(() ->
                new RuntimeException("Message not found with ID: " + message.getId())
        );

        // Update the fields of the existing entity with the new message details
        if(StringUtils.isNotBlank(message.getMessage())){
            messageEntity.setMessage(message.getMessage());
        }
        if((message.getSenderId())!=0){
            messageEntity.setSenderId(message.getSenderId());
        }
        if((message.getReceiverId())!=0){
            messageEntity.setReceiverId(message.getReceiverId());
        }

        // Save the updated entity back to the repository
         messageEntity=messageRepository.save(messageEntity);

        // Convert the updated entity back into a Message object
        Message updatedMessage = new Message();
        BeanUtils.copyProperties(messageEntity,updatedMessage);



        return updatedMessage;
    }



    public String deleteMessage(Integer id) {
        // Check if the message exists
        Boolean isExists = messageRepository.existsById(id);
        if (isExists) {
            messageRepository.deleteById(id);
            return "Item is deleted successfully";
        } else {
            return "Item is not found";
        }


    }

   @Override
    public List<String> getSenderMessages(Integer senderId) {
        return messageRepository.getMessagesById(senderId);
    }

    @Override
    public List<MessageEntity> getReceiverDetails(Integer receiverId) {
        return messageRepository.findByReceiverId(receiverId);
    }





}
