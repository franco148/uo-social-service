package com.umssonline.social.services.impl;

import com.umssonline.social.exceptions.InvalidResourceException;
import com.umssonline.social.models.dto.participant.ParticipantDto;
import com.umssonline.social.models.entity.Comment;
import com.umssonline.social.models.entity.Participant;
import com.umssonline.social.models.entity.Resource;
import com.umssonline.social.repositories.api.ExtendedCommentDao;
import com.umssonline.social.repositories.api.ExtendedParticipantDao;
import com.umssonline.social.repositories.api.ExtendedResourceDao;
import com.umssonline.social.feign.UsersClient;
import com.umssonline.social.services.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.Serializable;
import java.util.Collection;

@Slf4j
@Service("commentService")
//@Qualifier("commentService")
public class CommentServiceImpl implements CommentService {

    //region Properties
    @Autowired
    private ExtendedCommentDao commentDao;

    @Autowired
    private ExtendedResourceDao resourceDao;

    @Autowired
    private ExtendedParticipantDao participantDao;

    @Autowired
    private UsersClient usersClient;

    @Autowired
    private ModelMapper modelMapper;
    //endregion

    //region CrudSocialService Members
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

        Resource commentedResource = resourceDao.findById(entity.getCommentedResource().getId());
        if (commentedResource ==  null) {
            commentedResource = modelMapper.map(entity.getCommentedResource(), Resource.class);
            resourceDao.create(commentedResource);
        }

        ParticipantDto participantExists = usersClient.findParticipantDto(entity.getCreatedBy().getId());
        if (participantExists == null) {
            throw new InvalidResourceException("Participant with id: " + entity.getCreatedBy().getId() + " does not exist.");
        } else {
            Participant createdBy = participantDao.findById(entity.getCreatedBy().getId());
            if (createdBy == null) {
                participantDao.create(entity.getCreatedBy());
            }
        }

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

    //region CommentService Members

    @Transactional
    @Override
    public void deleteMessagesByResourceIdAndCommentId(Serializable resourceId, Serializable commentId) {
        boolean removedMessages = commentDao.deleteMessagesByResourceIdAndCommentId(resourceId, commentId);
        log.warn("Were comment and its messages removed? = " + removedMessages);

        commentDao.deleteById(commentId);
    }

    //endregion
}
