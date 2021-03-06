package com.umssonline.social.repositories.api;

import com.umssonline.social.models.entity.Message;

import java.io.Serializable;

public interface ExtendedMessageDao extends SocialServiceDao<Message> {

    Message findByIdAndCommentIdAndResourceId(Serializable messageId, Serializable commentId, Serializable resourceId);

    Message findByIdAndResourceId(Serializable messageId, Serializable resourceId);

    boolean deleteMessageByIdFromCommentAndResource(Serializable messageId, Serializable commentId, Serializable resourceId);
}
