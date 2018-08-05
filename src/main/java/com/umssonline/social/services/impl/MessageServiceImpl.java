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
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.Collection;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

    //region Properties
    @Autowired
    private ExtendedMessageDao messageDao;

    @Autowired
    private ExtendedParticipantDao participantDao;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ModelMapper modelMapper;
    //endregion


    //region CrudSocialService Members
    @Transactional(readOnly = true)
    @Override
    public Message findById(Serializable id) {
        return messageDao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Message> findByProperty(String propertyName) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<Message> findAll() {
        return messageDao.findAll();
    }

    @Transactional
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

        return messageDao.update(message);
    }

    @Transactional
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

    @Transactional
    @Override
    public void delete(Message message) {
        messageDao.delete(message);
    }

    @Transactional
    @Override
    public void deleteById(Serializable id) {
        messageDao.deleteById(id);
    }

    //endregion

    //region MessageService Members
    @Transactional(readOnly = true)
    @Override
    public Message findByIdAndResourceId(Serializable resourceId, Serializable messageId) {
        return messageDao.findByIdAndResourceId(messageId, resourceId);
    }

    @Transactional(readOnly = true)
    @Override
    public Message findByIdAndCommentIdAndResourceId(Serializable messageId, Serializable commentId, Serializable resourceId) {
        return messageDao.findByIdAndCommentIdAndResourceId(messageId, commentId, resourceId);
    }
    //endregion
}
