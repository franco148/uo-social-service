package com.umssonline.social.controllers;

import com.umssonline.social.models.dto.CreateCommentDto;
import com.umssonline.social.models.dto.UpdateCommentDto;
import com.umssonline.social.models.Comment;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface CommentsRestController {

    ResponseEntity<Comment> findById(final Long id) throws Exception;

    ResponseEntity<Collection<Comment>> findAll() throws Exception;

    Collection<Comment> findByProperty(final String property);

    ResponseEntity<Comment> create(final CreateCommentDto commentDto) throws Exception;

    ResponseEntity<Comment> update(final UpdateCommentDto commentDto);

    ResponseEntity<Void> deleteById(final Long id);

}
