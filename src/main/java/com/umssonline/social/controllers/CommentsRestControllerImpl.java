package com.umssonline.social.controllers;

import com.umssonline.social.models.dto.comment.CreateCommentDto;
import com.umssonline.social.models.dto.comment.UpdateCommentDto;
import com.umssonline.social.models.entity.Comment;
import com.umssonline.social.services.CrudSocialService;
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
    private CrudSocialService<Comment> commentService;

    @Autowired
    private ModelMapper modelMapper;
    //endregion

    //region CommentsRestController Members
    @Override
    @GetMapping("/{comment_id}")
    public ResponseEntity<Comment> findById(@PathVariable("comment_id") final Long id) {

        try {
            Comment commentResponse = commentService.findById(id);
            return new ResponseEntity<>(commentResponse, HttpStatus.OK);
        } catch (Exception ex) {
            //throw new Exception("Error on getting a comment: " + ex.getMessage());
            return null;
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<Collection<Comment>> findAll() {

        try {
            Collection<Comment> commentsResponse = commentService.findAll();

            if (commentsResponse.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(commentsResponse, HttpStatus.OK);
        } catch (Exception ex) {
            //throw new Exception("Error on getting comments: " + ex.getMessage());
            return null;
        }
    }

    @Override
    @GetMapping("/property")
    public Collection<Comment> findByProperty(@RequestParam("prop") final String property) {
        return null;
    }

    @Override
    @PostMapping
    public ResponseEntity<Comment> create(@RequestBody final CreateCommentDto commentDto) {
        Comment converted = modelMapper.map(commentDto, Comment.class);
        try {
            Comment savedComment = commentService.save(converted);
            return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            //throw new Exception("Save comment has failed. The operation has been terminated: " + ex.getMessage());
            return null;
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
