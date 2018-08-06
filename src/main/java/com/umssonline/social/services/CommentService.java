package com.umssonline.social.services;

import com.umssonline.social.models.entity.Comment;

import java.io.Serializable;

public interface CommentService extends CrudSocialService<Comment> {

    void deleteMessagesByResourceIdAndCommentId(Serializable resourceId, Serializable commentId);
}
