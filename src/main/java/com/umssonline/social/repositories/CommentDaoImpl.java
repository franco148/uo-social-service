package com.umssonline.social.repositories;

import com.umssonline.social.models.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImpl extends AbstractJpaDao<Comment> implements CommentDao {

    //region Constructors
    public CommentDaoImpl() {
        super();
        setClazz(Comment.class);
    }
    //endregion
}
