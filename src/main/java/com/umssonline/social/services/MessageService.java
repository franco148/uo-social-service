package com.umssonline.social.services;

import com.umssonline.social.models.entity.Message;

import java.io.Serializable;

public interface MessageService extends CrudSocialService<Message> {

    Message findByIdAndResourceId(Serializable resourceId, Serializable messageId);

    Message findByIdAndCommentIdAndResourceId(Serializable messageId, Serializable commentId, Serializable resourceId);

    void deleteMessageByIdFromCommentAndResource(Serializable messageId, Serializable commentId, Serializable resourceId);

    Message saveMessageInResource(Long resourceId, Message message);
}
