package com.umssonline.social.repositories.impl;

import com.umssonline.social.models.entity.Message;
import com.umssonline.social.repositories.api.ExtendedMessageDao;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class MessageDaoImpl extends AbstractJpaDao<Message> implements ExtendedMessageDao {

    //region Constructors

    public MessageDaoImpl() {
        super();
        setClazz(Message.class);
    }
    //endregion

    //region ExtendedMessageDao Members
    @Override
    public Message findByIdAndCommentIdAndResourceId(Serializable messageId, Serializable commentId, Serializable resourceId) {

        Message filteredMessage = this.entityManager.createQuery
                (
                    "select msg" +
                        "from Message msg" +
                        "join fetch msg.comment c" +
                        "join fetch c.commentedResource r",
                    Message.class
                ).getSingleResult();

        return filteredMessage;
    }
    //endregion
}
