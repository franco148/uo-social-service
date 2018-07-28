package com.umssonline.social.controllers;

import com.umssonline.social.models.dto.comment.CreateCommentDto;
import com.umssonline.social.models.dto.comment.CreateMessageDto;
import com.umssonline.social.models.dto.comment.UpdateMessageDto;
import com.umssonline.social.models.entity.Comment;
import com.umssonline.social.models.entity.Message;
import org.springframework.http.ResponseEntity;

public interface ResourcesRestController {

    //region Comments Operation

    // Find a comment with all its related messages
    ResponseEntity<Iterable<Comment>> findAllCommentMessagesByResource(final Long resourceId);

    // Create a Comment in a Resource
    ResponseEntity<Comment> createCommentInResource(final Long resourceId, final CreateCommentDto comment);

    // Find an specific Comment Message in a Resource
    ResponseEntity<Message> findCommentMessageByResource(final Long resourceId, final Long messageId);

    // Create a Comment Message in a Resource
    ResponseEntity<Message> createCommentMessageInResource(final Long resourceId, final CreateMessageDto message);

    // Update a specific message of a Resource
    ResponseEntity<Message> updateCommentMessageOfResource(final Long resourceId, final UpdateMessageDto message);

    // Delete all Comment Messages of a Resource
    ResponseEntity<Void> deleteCommentMessagesOfResource(final Long resourceId, final Long commentId);

    // Delete a specific Comment Message of a Resource
    ResponseEntity<Void> deleteCommentMessageOfResource(final Long resourceId, final Long commentId, final Long messageId);

    // Find a specific Comment by Resource
    ResponseEntity<Comment> findCommentByIdAndResource(final Long resourceId, final Long commentId);

    //endregion

    //region Shares Operation
    //endregion

    //region Rates Operation
    //endregion

}
