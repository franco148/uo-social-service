package com.umssonline.social.controllers;

import com.umssonline.social.common.dto.CreateMessageDto;
import com.umssonline.social.common.dto.UpdateMessageDto;
import com.umssonline.social.models.Message;
import com.umssonline.social.services.SocialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/messages")
public class MessagesRestControllerImpl implements MessagesRestController {

    //region Properties
    @Autowired
    private SocialService<Message> messageService;

    @Autowired
    private ModelMapper modelMapper;
    //endregion


    //region MessagesRestController Members
    @GetMapping("/{message_id}")
    @Override
    public ResponseEntity<Message> findById(@PathVariable("message_id") final Long id) throws Exception {

        try {
            Message messageResponse = messageService.findById(id);
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        } catch (Exception ex) {
            throw new Exception("Error on getting a message: " + ex.getMessage());
        }
    }

    @GetMapping
    @Override
    public ResponseEntity<Collection<Message>> findAll() throws Exception {

        try {
            Collection<Message> messagesResponse = messageService.findAll();

            if (messagesResponse.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(messagesResponse, HttpStatus.OK);
        } catch (Exception ex) {
            throw new Exception("Error on getting comments: " + ex.getMessage());
        }
    }

    @GetMapping("/property")
    @Override
    public ResponseEntity<Collection<Message>> findByProperty(final String property, final Object value) {
        return null;
    }

    @PostMapping
    @Override
    public ResponseEntity<Message> create(@RequestBody final CreateMessageDto messageDto) throws Exception {
        Message converted = modelMapper.map(messageDto, Message.class);

        try {
            Message savedMessage = messageService.save(converted);
            return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Save message has failed. The operation has been terminated: " + ex.getMessage());
        }
    }

    @PutMapping
    @Override
    public ResponseEntity<Message> update(@RequestBody final UpdateMessageDto messageDto) throws Exception {
        Message converted = modelMapper.map(messageDto, Message.class);

        try {
            Message updatedMessage = messageService.update(converted);
            return new ResponseEntity<>(updatedMessage, HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Update message has failed. The operation has been terminated: " + ex.getMessage());
        }
    }

    @DeleteMapping("/{message_id}")
    @Override
    public ResponseEntity<Void> deleteById(@PathVariable("message_id") final Long id) {
        messageService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //endregion
}
