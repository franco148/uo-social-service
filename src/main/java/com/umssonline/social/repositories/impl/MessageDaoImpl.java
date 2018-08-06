package com.umssonline.social.repositories.impl;

import com.umssonline.social.models.entity.Message;
import com.umssonline.social.repositories.api.ExtendedMessageDao;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

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
                    "select msg " +
                       "from Message msg " +
                       "join fetch msg.comment c " +
                       "join fetch c.commentedResource r " +
                       "where r.id = :resourceId AND c.id = :commentId AND msg.id = :messageId",
                    Message.class
                )
                .setParameter("resourceId", resourceId)
                .setParameter("commentId", commentId)
                .setParameter("messageId", messageId)
                .getSingleResult();

        return filteredMessage;
    }

    @Override
    public Message findByIdAndResourceId(Serializable messageId, Serializable resourceId) {

        Message filteredMessage = this.entityManager.createQuery
                (
                "select msg " +
                   "from Message msg " +
                   "join fetch msg.comment c " +
                   "join fetch c.commentedResource r " +
                   "where r.id = :resourceId AND msg.id = :messageId",
                   Message.class
                )
                .setParameter("messageId", messageId)
                .setParameter("resourceId", resourceId)
                .getSingleResult();

        return filteredMessage;
    }

    @Override
    public boolean deleteMessageByIdFromCommentAndResource(Serializable messageId, Serializable commentId, Serializable resourceId) {

//        DELETE FROM WordSet w
//        WHERE w IN
//                (SELECT ws FROM UserDictionary u
//                        JOIN u.wordSets ws
//                        WHERE u.user.username = :username AND ws.id = :id)

//        int removed = this.entityManager.createQuery
//                (
//                "delete from Message msg " +
//                   "where msg in " +
//                        "(select m from Comment c " +
//                        " join c.messages m " +
//                        " join c.commentedResource r " +
//                        " where c.id = :commentId AND r.id = :resourceId AND m.id = :messageId)"
//                )
//                .setParameter("resourceId", resourceId)
//                .setParameter("commentId", commentId)
//                .setParameter("messageId", messageId)
//                .executeUpdate();

        int removed = this.entityManager.createQuery
                (
                "update Message msg " +
                   "set msg.isDeleted = true " +
                   "where msg in " +
                        "(select m from Comment c " +
                        " join c.messages m " +
                        " join c.commentedResource r " +
                        " where c.id = :commentId AND r.id = :resourceId AND m.id = :messageId)"
                )
                .setParameter("resourceId", resourceId)
                .setParameter("commentId", commentId)
                .setParameter("messageId", messageId)
                .executeUpdate();

        System.out.println(removed);

        return removed == 1;
    }
    //endregion
}
