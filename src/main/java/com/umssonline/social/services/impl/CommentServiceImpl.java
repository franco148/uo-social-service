package com.umssonline.social.services.impl;

import com.umssonline.social.models.entity.Comment;
import com.umssonline.social.models.entity.Participant;
import com.umssonline.social.models.entity.Resource;
import com.umssonline.social.repositories.api.ExtendedCommentDao;
import com.umssonline.social.repositories.feign.UsersClient;
import com.umssonline.social.services.CommentService;
import com.umssonline.social.services.ParticipantService;
import com.umssonline.social.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.Serializable;
import java.util.Collection;

@Service("commentService")
//@Qualifier("commentService")
public class CommentServiceImpl implements CommentService {

    //region Properties
    @Autowired
    private ExtendedCommentDao commentDao;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private UsersClient usersClient;
    //endregion

    //region SocialService Members
    @Transactional(readOnly = true)
    @Override
    public Comment findById(Serializable id) {
        return commentDao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Comment> findByProperty(String propertyName) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Comment> findAll() {
        return commentDao.findAll();
    }

    @Transactional
    @Override
    public Comment save(Comment entity) {

        if (entity.getCommentedResource() == null || entity.getCreatedBy() == null) {
            //throw new Exception("Neither Resource nor CreatedBy properties can be null.");
        }

        Resource resourceFromDb = resourceService.findById(entity.getCommentedResource().getId());
        if (resourceFromDb == null) {
            //throw new Exception("Comment can not be created, it does not have a related Resource");
        }

        Participant participantFromDb = participantService.findById(entity.getCreatedBy().getId());
        if (participantFromDb == null) {
            //throw new Exception("The owner who is creating the comment does not exists.");
        }

        entity.setCommentedResource(resourceFromDb);
        entity.setCreatedBy(participantFromDb);

        return commentDao.create(entity);
    }

    @Transactional
    @Override
    public Comment update(Comment entity) {
        throw new NotImplementedException();
    }

    @Transactional
    @Override
    public void delete(Comment entity) {
        commentDao.deleteById(entity.getId());
    }

    @Transactional
    @Override
    public void deleteById(Serializable id) {
        commentDao.deleteById(id);
    }
    //endregion

    //region Helpers
    //endregion
}
