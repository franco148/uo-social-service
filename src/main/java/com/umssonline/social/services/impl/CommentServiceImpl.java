package com.umssonline.social.services.impl;

import com.umssonline.social.models.dto.participant.ParticipantDto;
import com.umssonline.social.models.entity.Comment;
import com.umssonline.social.models.entity.Participant;
import com.umssonline.social.models.entity.Resource;
import com.umssonline.social.repositories.api.ExtendedCommentDao;
import com.umssonline.social.repositories.api.ExtendedResourceDao;
import com.umssonline.social.repositories.feign.UsersClient;
import com.umssonline.social.services.CommentService;
import com.umssonline.social.services.ParticipantService;
import com.umssonline.social.services.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.EntityNotFoundException;
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
    private ResourceService resourceService;

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private UsersClient usersClient;

    @Autowired
    private ModelMapper modelMapper;
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

        Resource commentedResource = resourceDao.findById(entity.getCommentedResource().getId());
        if (commentedResource ==  null) {
            commentedResource = modelMapper.map(entity.getCommentedResource(), Resource.class);
            resourceDao.create(commentedResource);
        }

        ParticipantDto createdBy = usersClient.findParticipantDto(entity.getCreatedBy().getId());
        if (createdBy == null) {
            throw new EntityNotFoundException("Participant with id: " + entity.getCreatedBy().getId() + " does not exist.");
        }

        entity.setCommentedResource(commentedResource);
        return commentDao.create(entity);
        //return null;
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
