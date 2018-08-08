package com.umssonline.social.repositories.impl;

import com.umssonline.social.models.entity.Comment;
import com.umssonline.social.repositories.api.ExtendedCommentDao;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class CommentDaoImpl extends AbstractJpaDao<Comment> implements ExtendedCommentDao {

    //region Constructors
    public CommentDaoImpl() {
        super();
        setClazz(Comment.class);
    }
    //endregion

    //region ExtendedCommentDao Members

    @Override
    public boolean deleteMessagesByResourceIdAndCommentId(Serializable resourceId, Serializable commentId) {
        int removed = this.entityManager.createQuery
                (
                "update Message msg " +
                   "set msg.isDeleted = true " +
                   "where msg in " +
                        "(select m from Comment c " +
                        " join c.messages m " +
                        " join c.commentedResource r " +
                        " where c.id = :commentId AND r.id = :resourceId)"
                )
                .setParameter("resourceId", resourceId)
                .setParameter("commentId", commentId)
                .executeUpdate();

        System.out.println(removed);

        return removed == 1;
    }
    //endregion
}
