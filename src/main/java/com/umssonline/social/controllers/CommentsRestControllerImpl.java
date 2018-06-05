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
public class CommentsRestControllerImpl implements CommentsRestController {

    //region Properties
    @Resource
    private SocialService<Comment> commentService;

    @Autowired
    private ModelMapper modelMapper;
    //endregion

    //region CommentsRestController Members
    @Override
    public ResponseEntity<Comment> findById(Long id) throws Exception {

        try {
            Comment commentResponse = commentService.findById(id);
            return new ResponseEntity<>(commentResponse, HttpStatus.OK);
        } catch (Exception ex) {
            throw new Exception("Error on getting a comment: " + ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<Collection<Comment>> findAll() throws Exception {

        try {
            Collection<Comment> commentsResponse = commentService.findAll();

            if (commentsResponse.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(commentsResponse, HttpStatus.OK);
        } catch (Exception ex) {
            throw new Exception("Error on getting a comment: " + ex.getMessage());
        }
    }

    @Override
    public Collection<Comment> findByProperty(String property) {
        return null;
    }

    @Override
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
    //@PutMapping
    public ResponseEntity<Comment> update(@RequestBody final UpdateCommentDto commentDto) {
        throw new NotImplementedException();
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        commentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //endregion
}
