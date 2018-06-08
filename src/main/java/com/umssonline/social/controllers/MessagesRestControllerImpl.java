package com.umssonline.social.controllers;

import com.umssonline.social.common.dto.CreateCommentDto;
import com.umssonline.social.common.dto.UpdateCommentDto;
import com.umssonline.social.models.Message;
import com.umssonline.social.services.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/messages")
public class MessagesRestControllerImpl implements MessagesRestController {

    //region Properties
    @Autowired
    private SocialService<Message> messageService;
    //endregion


    //region MessagesRestController Members
    @GetMapping("/{message_id}")
    @Override
    public ResponseEntity<Message> findById(@PathVariable("message_id") final Long id) {
        return null;
    }

    @GetMapping
    @Override
    public ResponseEntity<Collection<Message>> findAll() {
        return null;
    }

    @GetMapping("/property")
    @Override
    public ResponseEntity<Collection<Message>> findByProperty(final String property, final Object value) {
        return null;
    }

    @PostMapping
    @Override
    public ResponseEntity<Message> create(@RequestBody final CreateCommentDto commentDto) {
        return null;
    }

    @PutMapping
    @Override
    public ResponseEntity<Message> update(@RequestBody final UpdateCommentDto updateCommentDto) {
        return null;
    }

    @DeleteMapping("/{message_id}")
    @Override
    public ResponseEntity<Void> deleteById(@PathVariable("message_id") final Long id) {
        return null;
    }
    //endregion
}
