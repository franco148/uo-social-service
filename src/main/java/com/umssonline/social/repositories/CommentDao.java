package com.umssonline.social.repositories;

import com.umssonline.social.models.Comment;

import java.io.Serializable;
import java.util.Collection;

public interface CommentDao {

    Comment findById(Serializable id);
    Collection<Comment> findAll();
    Comment create(Comment comment);
    Comment update(Comment comment);
    void delete(Comment comment);
    void deleteById(Serializable id);
}
