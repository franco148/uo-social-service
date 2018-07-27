package com.umssonline.social.repositories.impl;

import com.umssonline.social.models.entity.Comment;
import com.umssonline.social.repositories.api.ExtendedCommentDao;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImpl extends AbstractJpaDao<Comment> implements ExtendedCommentDao {

    //region Constructors
    public CommentDaoImpl() {
        super();
        setClazz(Comment.class);
    }
    //endregion
}
