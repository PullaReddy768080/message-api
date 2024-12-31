package com.demo.springboot.demo.message.repository;

import com.demo.springboot.demo.message.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {
    @Query("SELECT message FROM MessageEntity where senderId=:senderId")
    List<String> getMessagesById(Integer senderId);

     @Query("FROM MessageEntity where receiverId=:receiverId")
    List<MessageEntity> findByReceiverId(Integer receiverId);
}