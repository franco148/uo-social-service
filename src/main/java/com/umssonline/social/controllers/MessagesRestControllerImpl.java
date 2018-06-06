package com.umssonline.social.controllers;

import com.umssonline.social.common.dto.CreateCommentDto;
import com.umssonline.social.common.dto.UpdateCommentDto;
import com.umssonline.social.models.Message;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public class MessagesRestControllerImpl implements MessagesRestController {

    //region Properties
    //endregion


    //region MessagesRestController Members
    @Override
    public ResponseEntity<Message> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Collection<Message>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Collection<Message>> findByProperty(String property, Object value) {
        return null;
    }

    @Override
    public ResponseEntity<Message> create(CreateCommentDto commentDto) {
        return null;
    }

    @Override
    public ResponseEntity<Message> update(UpdateCommentDto updateCommentDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        return null;
    }
    //endregion
}
