package com.umssonline.social.services;

import com.umssonline.social.models.Comment;
import com.umssonline.social.models.Message;
import com.umssonline.social.repositories.api.ExtendedMessageDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;

@Service("messageService")
public class MessageServiceImpl implements SocialService<Message> {

    //region Properties
    @Resource
    private ExtendedMessageDao messageDao;

    @Resource
    private SocialService<Comment> commentService;
    //endregion


    //region SocialService Members
    @Override
    public Message findById(Serializable id) throws Exception {
        return messageDao.findById(id);
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
    public Message save(Message message) throws Exception {

        if (message.getComment() == null || message.getCreatedBy() == null) {
            throw new Exception("Neither Comment nor CreatedBy properties can be null.");
        }

        Comment commentFromDb = commentService.findById(message.getComment().getId());
        if (commentFromDb == null) {
            throw new Exception("Message can not be created, it does not have a related Comment");
        }

        message.setComment(commentFromDb);

        return messageDao.create(message);
    }

    @Override
    public Message update(Message message) {
        return null;
    }

    @Override
    public void delete(Message message) {

    }

    @Override
    public void deleteById(Serializable id) {

    }
    //endregion
}
