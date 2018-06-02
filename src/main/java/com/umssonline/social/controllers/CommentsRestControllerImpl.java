package com.umssonline.social.controllers;

import com.umssonline.social.common.dto.CreateCommentDto;
import com.umssonline.social.common.dto.UpdateCommentDto;
import com.umssonline.social.models.Comment;
import com.umssonline.social.services.SocialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Comment> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Collection<Comment>> findAll() {
        return null;
    }

    @Override
    public Collection<Comment> findByProperty(String property) {
        return null;
    }

    @Override
    public ResponseEntity<Comment> create(@RequestBody final CreateCommentDto commentDto) {
        Comment converted = modelMapper.map(commentDto, Comment.class);
        commentService.save(converted);
        return null;
    }

    @Override
    //@PutMapping
    public ResponseEntity<Comment> update(@RequestBody final UpdateCommentDto commentDto) {
        Comment updatedConvert = modelMapper.map(commentDto, Comment.class);
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        return null;
    }
    //endregion
}
