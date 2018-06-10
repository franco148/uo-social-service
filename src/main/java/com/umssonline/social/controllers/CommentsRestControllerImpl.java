package com.umssonline.social.controllers;

import com.umssonline.social.common.dto.CreateCommentDto;
import com.umssonline.social.common.dto.UpdateCommentDto;
import com.umssonline.social.models.Comment;
import com.umssonline.social.services.SocialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping("/comments")
public class CommentsRestControllerImpl implements CommentsRestController {

    //region Properties
    @Resource
    private SocialService<Comment> commentService;

    @Autowired
    private ModelMapper modelMapper;
    //endregion

    //region CommentsRestController Members
    @Override
    @GetMapping("/{comment_id}")
    public ResponseEntity<Comment> findById(@PathVariable("comment_id") final Long id) throws Exception {

        try {
            Comment commentResponse = commentService.findById(id);
            return new ResponseEntity<>(commentResponse, HttpStatus.OK);
        } catch (Exception ex) {
            throw new Exception("Error on getting a comment: " + ex.getMessage());
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<Collection<Comment>> findAll() throws Exception {

        try {
            Collection<Comment> commentsResponse = commentService.findAll();

            if (commentsResponse.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(commentsResponse, HttpStatus.OK);
        } catch (Exception ex) {
            throw new Exception("Error on getting comments: " + ex.getMessage());
        }
    }

    @Override
    @GetMapping("/property")
    public Collection<Comment> findByProperty(@RequestParam("prop") final String property) {
        return null;
    }

    @Override
    @PostMapping
    public ResponseEntity<Comment> create(@RequestBody final CreateCommentDto commentDto) throws Exception {
        Comment converted = modelMapper.map(commentDto, Comment.class);
        try {
            Comment savedComment = commentService.save(converted);
            return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Save comment has failed. The operation has been terminated: " + ex.getMessage());
        }
    }

    @Override
    @PutMapping
    public ResponseEntity<Comment> update(@RequestBody final UpdateCommentDto commentDto) {
        throw new NotImplementedException();
    }

    @Override
    @DeleteMapping("/{comment_id}")
    public ResponseEntity<Void> deleteById(@PathVariable("comment_id") final Long id) {
        commentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //endregion
}
