package com.umssonline.social.services;

import com.umssonline.social.models.Comment;
import com.umssonline.social.models.Participant;
import com.umssonline.social.repositories.api.ExtendedCommentDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

@Service("commentService")
//@Qualifier("commentService")
public class CommentServiceImpl implements SocialService<Comment> {

    //region Properties
    @Resource
    private ExtendedCommentDao commentDao;

    @Resource
    private SocialService<com.umssonline.social.models.Resource> resourceService;

    @Resource
    private SocialService<Participant> participantService;
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
    public Comment save(Comment entity) throws Exception {
        com.umssonline.social.models.Resource resourceFromDb = resourceService.findById(entity.getCommentedResource().getId());
        if (resourceFromDb == null) {
            throw new Exception("Comment can not be created, it does not have a related Resource");
        }

        //if ()

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
