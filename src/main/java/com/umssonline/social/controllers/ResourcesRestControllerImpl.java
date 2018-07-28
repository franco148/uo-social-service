package com.umssonline.social.controllers;

import com.umssonline.social.models.dto.comment.CreateCommentDto;
import com.umssonline.social.models.dto.comment.CreateMessageDto;
import com.umssonline.social.models.dto.comment.UpdateMessageDto;
import com.umssonline.social.models.entity.Comment;
import com.umssonline.social.models.entity.Message;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/resources")
public class ResourcesRestControllerImpl implements ResourcesRestController {

    @Autowired
    private ModelMapper modelMapper;

    //region Comments Operations

    @GetMapping("/{resource_id}")
    @Override
    public ResponseEntity<Iterable<Comment>> findAllCommentMessagesByResource(@PathVariable("resource_id") final Long resourceId) {
        return null;
    }

    @PostMapping("/{resource_id}/comment")
    @Override
    public ResponseEntity<Comment> createCommentInResource(@PathVariable("resource_id") final Long resourceId,
                                                           @Valid @RequestBody final CreateCommentDto comment) {
        return null;
    }

    @GetMapping("/{resource_id}/message/{message_id}")
    @Override
    public ResponseEntity<Message> findCommentMessageByResource(@PathVariable("resource_id") final Long resourceId,
                                                                @PathVariable("message_id") final Long messageId) {
        return null;
    }

    @PostMapping("/{resource_id}/message")
    @Override
    public ResponseEntity<Message> createCommentMessageInResource(@PathVariable("resource_id") final Long resourceId,
                                                                  @Valid @RequestBody final CreateMessageDto message) {
        return null;
    }

    @PutMapping("/{resource_id}/message")
    @Override
    public ResponseEntity<Message> updateCommentMessageOfResource(@PathVariable("resource_id") final Long resourceId,
                                                                  @Valid @RequestBody final UpdateMessageDto message) {

        Message converted = modelMapper.map(message, Message.class);
        System.out.println(converted);

        return null;
    }

    @DeleteMapping("/{resource_id}/comment/{comment_id}")
    @Override
    public ResponseEntity<Void> deleteCommentMessagesOfResource(@PathVariable("resource_id") final Long resourceId,
                                                                @PathVariable("comment_id") final Long commentId) {
        return null;
    }

    @DeleteMapping("/{resource_id}/comment/{comment_id}/message/{message_id}")
    @Override
    public ResponseEntity<Void> deleteCommentMessageOfResource(@PathVariable("resource_id") final Long resourceId,
                                                               @PathVariable("comment_id") final Long commentId,
                                                               @PathVariable("message_id") Long messageId) {
        return null;
    }

    @GetMapping("/{resource_id}/comment/{comment_id}")
    @Override
    public ResponseEntity<Comment> findCommentByIdAndResource(@PathVariable("resource_id") final Long resourceId,
                                                              @PathVariable("comment_id") Long commentId) {
        return null;
    }
    //endregion
}
