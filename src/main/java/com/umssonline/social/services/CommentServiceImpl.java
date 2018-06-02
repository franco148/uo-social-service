package com.umssonline.social.services;

import com.umssonline.social.models.Comment;
import com.umssonline.social.repositories.api.ExtendedCommentDao;
import com.umssonline.social.repositories.api.ExtendedResourceDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

@Service
@Qualifier("commentService")
public class CommentServiceImpl implements SocialService<Comment> {

    //region Properties
    @Resource
    private ExtendedCommentDao commentDao;

    @Resource
    private ExtendedResourceDao resourceDao;
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
        com.umssonline.social.models.Resource fromDb = resourceDao.findById(entity.getCommentedResource().getId());
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
