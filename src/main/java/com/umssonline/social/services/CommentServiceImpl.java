package com.umssonline.social.services;

import com.umssonline.social.models.Comment;
import com.umssonline.social.repositories.api.ExtendedCommentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

@Service
public class CommentServiceImpl implements SocialService<Comment> {

    //region Properties
    @Resource
    private ExtendedCommentDao extendedCommentDao;
    //endregion

    //region SocialService Members
    @Override
    public Comment findById(Serializable id) {
        return null;
    }

    @Override
    public Collection<Comment> findByProperty(String propertyName) {
        return null;
    }

    @Override
    public Collection<Comment> findAll() {
        return null;
    }

    @Override
    public Comment save(Comment entity) {
        return null;
    }

    @Override
    public Comment update(Comment entity) {
        return null;
    }

    @Override
    public void delete(Comment entity) {

    }

    @Override
    public void deleteById(Serializable id) {

    }
    //endregion

    //region Helpers
    //endregion
}
