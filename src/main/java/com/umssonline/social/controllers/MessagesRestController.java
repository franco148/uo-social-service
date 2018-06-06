package com.umssonline.social.controllers;

import com.umssonline.social.common.dto.CreateCommentDto;
import com.umssonline.social.common.dto.UpdateCommentDto;
import com.umssonline.social.models.Message;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface MessagesRestController {

    ResponseEntity<Message> findById(final Long id);

    ResponseEntity<Collection<Message>> findAll();

    ResponseEntity<Collection<Message>> findByProperty(final String property, final Object value);

    ResponseEntity<Message> create(final CreateCommentDto commentDto);

    ResponseEntity<Message> update(final UpdateCommentDto updateCommentDto);

    ResponseEntity<Void> deleteById(final Long id);
}
