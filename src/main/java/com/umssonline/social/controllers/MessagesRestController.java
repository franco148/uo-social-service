package com.umssonline.social.controllers;

import com.umssonline.social.models.dto.comment.CreateMessageDto;
import com.umssonline.social.models.dto.comment.UpdateMessageDto;
import com.umssonline.social.models.entity.Message;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface MessagesRestController {

    ResponseEntity<Message> findById(final Long id) throws Exception;

    ResponseEntity<Collection<Message>> findAll() throws Exception;

    ResponseEntity<Collection<Message>> findByProperty(final String property, final Object value);

    ResponseEntity<Message> create(final CreateMessageDto messageDto) throws Exception;

    ResponseEntity<Message> update(final UpdateMessageDto messageDto) throws Exception;

    ResponseEntity<Void> deleteById(final Long id);
}
