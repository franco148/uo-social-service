package com.umssonline.social.services.impl;

import com.umssonline.social.models.entity.Comment;
import com.umssonline.social.models.entity.Message;
import com.umssonline.social.models.entity.Participant;
import com.umssonline.social.repositories.api.ExtendedMessageDao;
import com.umssonline.social.repositories.api.ExtendedParticipantDao;
import com.umssonline.social.services.CommentService;
import com.umssonline.social.services.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.Collection;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

    //region Properties
    @Autowired
    private ExtendedMessageDao messageDao;

    private ExtendedParticipantDao participantDao;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ModelMapper modelMapper;
    //endregion


    //region SocialService Members
    @Override
    public Message findById(Serializable id) {
        return messageDao.findById(id);
    }

    @Override
    public Message findByIdAndResource(Serializable resourceId, Serializable messageId) {
        Message savedMessage = messageDao.findById(messageId);

        Long commentedResourceId = savedMessage.getComment().getCommentedResource().getId();
        if (resourceId != commentedResourceId) {
            throw new EntityNotFoundException("Message with a specified ID and ResourceId does not exist.");
        }

        return savedMessage;
    }

    @Override
    public Collection<Message> findByProperty(String propertyName) {
        return null;
    }

    @Override
    public Collection<Message> findAll() {
        return messageDao.findAll();
    }

    @Override
    public Message save(Message message) {

        Comment commentFromDb = commentService.findById(message.getComment().getId());
        if (commentFromDb == null) {
            throw new EntityNotFoundException("Message can not be created, it does not have a related Comment");
        }

        Participant createdBy = participantDao.findById(message.getCreatedBy().getId());
        if (createdBy == null) {
            participantDao.create(message.getCreatedBy());
        }

        return messageDao.create(message);
    }

    @Override
    public Message update(Message message) {

        Comment commentFromDb = commentService.findById(message.getComment().getId());
        if (commentFromDb == null) {
            throw new EntityNotFoundException("Related comment to the message does not exist.");
        }

        Message messageFromDb = messageDao.findById(message.getId());
        if (messageFromDb == null) {
            throw new EntityNotFoundException("Message to be updated does not exist.");
        }

        modelMapper.map(message, messageFromDb);

        return messageDao.update(messageFromDb);
    }

    @Override
    public void delete(Message message) {
        messageDao.delete(message);
    }

    @Override
    public void deleteById(Serializable id) {
        messageDao.deleteById(id);
    }

    //endregion
}
