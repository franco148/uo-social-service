package com.umssonline.social.repositories.api;

import com.umssonline.social.models.Comment;

import java.io.Serializable;
import java.util.Collection;

public interface ExtendedCommentDao extends SocialServiceDao<Comment> {

    Comment findById(Serializable id);
    Collection<Comment> findAll();
    Comment create(Comment comment);
    Comment update(Comment comment);
    void delete(Comment comment);
    void deleteById(Serializable id);
}
