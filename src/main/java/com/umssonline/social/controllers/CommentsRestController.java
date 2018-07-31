package com.umssonline.social.controllers;

import com.umssonline.social.models.dto.comment.CreateCommentDto;
import com.umssonline.social.models.dto.comment.UpdateCommentDto;
import com.umssonline.social.models.entity.Comment;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface CommentsRestController {

    ResponseEntity<Comment> findById(final Long id);

    ResponseEntity<Collection<Comment>> findAll();

    Collection<Comment> findByProperty(final String property);

    ResponseEntity<Comment> create(final CreateCommentDto commentDto);

    ResponseEntity<Comment> update(final UpdateCommentDto commentDto);

    ResponseEntity<Void> deleteById(final Long id);

}
