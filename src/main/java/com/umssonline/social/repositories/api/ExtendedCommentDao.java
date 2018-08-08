package com.umssonline.social.repositories.api;

import com.umssonline.social.models.entity.Comment;

import java.io.Serializable;

public interface ExtendedCommentDao extends SocialServiceDao<Comment> {

    boolean deleteMessagesByResourceIdAndCommentId(Serializable resourceId, Serializable commentId);
}
