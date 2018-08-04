package com.umssonline.social.services.impl;

import com.umssonline.social.models.entity.Comment;
import com.umssonline.social.models.entity.Message;
import com.umssonline.social.repositories.api.ExtendedMessageDao;
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

        if (message.getComment() == null || message.getCreatedBy() == null) {
            //throw new Exception("Neither Comment nor CreatedBy properties can be null.");
        }

        Comment commentFromDb = commentService.findById(message.getComment().getId());
        if (commentFromDb == null) {
            //throw new Exception("Message can not be created, it does not have a related Comment");
        }

        message.setComment(commentFromDb);

        return messageDao.create(message);
    }

    @Override
    public Message update(Message message) {

        Message messageFromDb = messageDao.findById(message.getId());
        if (messageFromDb == null) {
            //throw new Exception("");
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
