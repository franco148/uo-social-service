package com.umssonline.social.controllers;

import com.umssonline.social.models.dto.comment.CreateCommentDto;
import com.umssonline.social.models.dto.comment.CreateMessageDto;
import com.umssonline.social.models.dto.comment.UpdateMessageDto;
import com.umssonline.social.models.dto.rate.CreateRateDto;
import com.umssonline.social.models.dto.rate.CreateScoreDto;
import com.umssonline.social.models.dto.rate.UpdateRateDto;
import com.umssonline.social.models.dto.share.CreateShareActionDto;
import com.umssonline.social.models.dto.share.CreateShareDto;
import com.umssonline.social.models.dto.share.UpdateShareActionDto;
import com.umssonline.social.models.entity.*;
import org.springframework.http.ResponseEntity;

public interface ResourcesRestController {

    //region Comments Operation

    // Find a comment with all its related messages
    ResponseEntity<Comment> findAllCommentMessagesByResource(final Long resourceId);

    // Create a Comment in a Resource
    ResponseEntity<Comment> createCommentInResource(final Long resourceId, final CreateCommentDto comment);

    // Find an specific Comment Message in a Resource
    ResponseEntity<Message> findCommentMessageByResource(final Long resourceId, final Long messageId);

    // Create a Comment Message in a Resource
    ResponseEntity<Message> createCommentMessageInResource(final Long resourceId, final CreateMessageDto message);

    // Update a specific message of a Resource
    ResponseEntity<Message> updateCommentMessageOfResource(final Long resourceId, final UpdateMessageDto message);

    // Delete all Comment Messages of a Resource
    ResponseEntity<Void> deleteAllCommentMessagesOfResource(final Long resourceId, final Long commentId);

    // Delete a specific Comment Message of a Resource
    ResponseEntity<Void> deleteCommentMessageOfResource(final Long resourceId, final Long commentId, final Long messageId);

    // Find a specific Comment by Resource (comment only)
    ResponseEntity<Comment> findCommentByIdAndResource(final Long resourceId, final Long commentId);

    //endregion

    //region Shares Operation

    // Find a share with all its relates sharing actions
    ResponseEntity<Share> findAllSharesByResource(final Long resourceId);

    // Find a specific Share by Resource (score only)
    ResponseEntity<Share> findShareByIdAndResource(final Long resourceId, final Long shareId);

    // Create share in a Resource
    ResponseEntity<Share> createShareInResource(final Long resourceId, final CreateShareDto share);

    // Find a specific Share Action in a Resource
    ResponseEntity<ShareAction> findShareActionByResource(final Long resourceId, final Long shareActionId);

    // Share a Resource
    ResponseEntity<ShareAction> shareResource(final Long resourceId, final CreateShareActionDto shareAction);

    // Update a specific share action of a resource
    ResponseEntity<ShareAction> updateShareOfResource(final Long resourceId, final UpdateShareActionDto shareAction);

    // Delete a share action rate of a Resource
    ResponseEntity<Void> deleteShareOfResource(final Long resourceId, final Long shareId, final Long shareActionId);

    // Delete all Share Actions of a Resource
    ResponseEntity<Void> deleteAllShareActionsOfResource(final Long resourceId, final Long shareId);
    //endregion

    //region Rates Operation

    // Find a score with all its relates rates
    ResponseEntity<Score> findAllScoreRatesByResource(final Long resourceId);

    // Find a specific Score by Resource (score only)
    ResponseEntity<Score> findScoreByIdAndResource(final Long resourceId, final Long scoreId);

    // Create score in a Resource
    ResponseEntity<Score> createScoreInResource(final Long resourceId, final CreateScoreDto score);

    // Find a specific Score Rate in a Resource
    ResponseEntity<Rate> findScoreRateByResource(final Long resourceId, final Long rateId);

    // Rate a Resource
    ResponseEntity<Rate> rateToResource(final Long resourceId, final CreateRateDto rate);

    // Update a specific rate of a resource
    ResponseEntity<Rate> updateRateOfResource(final Long resourceId, final UpdateRateDto rate);

    // Delete a specific rate of a Resource
    ResponseEntity<Void> deleteRateOfResource(final Long resourceId, final Long scoreId, final Long rateId);

    // Delete all Rates of a Resource
    ResponseEntity<Void> deleteAllRatesOfResource(final Long resourceId, final Long scoreId);
    //endregion

}
