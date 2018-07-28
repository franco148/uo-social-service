package com.umssonline.social.controllers;

import com.umssonline.social.models.entity.Comment;
import com.umssonline.social.models.entity.Message;
import org.springframework.http.ResponseEntity;

public interface ResourcesRestController {

    //region Comments Operation

    /**
     * This is going to return the comments entity with its related messages.
     * @param resourceId The id of the resource.
     * @return Comment Entity with its related messages
     */
    ResponseEntity<Iterable<Comment>> findAllCommentsByResource(final Long resourceId);

    ResponseEntity<Message> findCommentMessageByResource(final Long resourceId, final Long messageId);

    ResponseEntity<Message> createCommentMessageInResource();

    //endregion

//    ResponseEntity<Comment> findById(final Long id);
//
//    ResponseEntity<Collection<Comment>> findAll();
//
//    Collection<Comment> findByProperty(final String property);
//
//    ResponseEntity<Comment> create(final CreateCommentDto commentDto);
//
//    ResponseEntity<Comment> update(final UpdateCommentDto commentDto);
//
//    ResponseEntity<Void> deleteById(final Long id);
}
