package com.umssonline.social.repositories.impl;

import com.umssonline.social.models.entity.Message;
import com.umssonline.social.repositories.api.ExtendedMessageDao;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDaoImpl extends AbstractJpaDao<Message> implements ExtendedMessageDao {

    //region Constructors

    public MessageDaoImpl() {
        super();
        setClazz(Message.class);
    }
    //endregion
}
