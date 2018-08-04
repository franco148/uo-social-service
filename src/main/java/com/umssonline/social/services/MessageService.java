package com.umssonline.social.services;

import com.umssonline.social.models.entity.Message;

import java.io.Serializable;

public interface MessageService extends CrudSocialService<Message> {

    Message findByIdAndResource(Serializable resourceId, Serializable messageId);
}
