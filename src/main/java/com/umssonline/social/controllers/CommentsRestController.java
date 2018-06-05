package com.umssonline.social.controllers;

import com.umssonline.social.common.dto.CreateCommentDto;
import com.umssonline.social.common.dto.UpdateCommentDto;
import com.umssonline.social.models.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/comments")
public interface CommentsRestController {

    @GetMapping("/{comment_id}")
    ResponseEntity<Comment> findById(@PathVariable("comment_id") Long id) throws Exception;

    @GetMapping
    ResponseEntity<Collection<Comment>> findAll() throws Exception;

    @GetMapping("/property")
    Collection<Comment> findByProperty(@RequestParam("prop") String property);

    @PostMapping
    ResponseEntity<Comment> create(final CreateCommentDto commentDto) throws Exception;

    @PutMapping
    ResponseEntity<Comment> update(final UpdateCommentDto commentDto);

    @DeleteMapping("/{comment_id}")
    ResponseEntity<Void> deleteById(@PathVariable("comment_id") Long id);

}
