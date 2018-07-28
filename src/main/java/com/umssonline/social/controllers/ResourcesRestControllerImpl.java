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
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/resources")
public class ResourcesRestControllerImpl implements ResourcesRestController {

    @Autowired
    private ModelMapper modelMapper;

    //region Comments Operations

    @GetMapping("/{resource_id}/comments")
    @Override
    public ResponseEntity<Comment> findAllCommentMessagesByResource(@PathVariable("resource_id") final Long resourceId) {
        return null;
    }

    @PostMapping("/{resource_id}/comment")
    @Override
    public ResponseEntity<Comment> createCommentInResource(@PathVariable("resource_id") final Long resourceId,
                                                           @Valid @RequestBody final CreateCommentDto comment) {
        return null;
    }

    @GetMapping("/{resource_id}/message/{message_id}")
    @Override
    public ResponseEntity<Message> findCommentMessageByResource(@PathVariable("resource_id") final Long resourceId,
                                                                @PathVariable("message_id") final Long messageId) {
        return null;
    }

    @PostMapping("/{resource_id}/message")
    @Override
    public ResponseEntity<Message> createCommentMessageInResource(@PathVariable("resource_id") final Long resourceId,
                                                                  @Valid @RequestBody final CreateMessageDto message) {
        return null;
    }

    @PutMapping("/{resource_id}/message")
    @Override
    public ResponseEntity<Message> updateCommentMessageOfResource(@PathVariable("resource_id") final Long resourceId,
                                                                  @Valid @RequestBody final UpdateMessageDto message) {

        Message converted = modelMapper.map(message, Message.class);
        System.out.println(converted);

        return null;
    }

    @DeleteMapping("/{resource_id}/comment/{comment_id}")
    @Override
    public ResponseEntity<Void> deleteAllCommentMessagesOfResource(@PathVariable("resource_id") final Long resourceId,
                                                                   @PathVariable("comment_id") final Long commentId) {
        return null;
    }

    @DeleteMapping("/{resource_id}/comment/{comment_id}/message/{message_id}")
    @Override
    public ResponseEntity<Void> deleteCommentMessageOfResource(@PathVariable("resource_id") final Long resourceId,
                                                               @PathVariable("comment_id") final Long commentId,
                                                               @PathVariable("message_id") Long messageId) {
        return null;
    }

    @GetMapping("/{resource_id}/comment/{comment_id}")
    @Override
    public ResponseEntity<Comment> findCommentByIdAndResource(@PathVariable("resource_id") final Long resourceId,
                                                              @PathVariable("comment_id") Long commentId) {
        return null;
    }

    //endregion

    //region Shares Operation

    @GetMapping("/{resource_id}/shares")
    @Override
    public ResponseEntity<Share> findAllSharesByResource(@PathVariable("resource_id") final Long resourceId) {
        return null;
    }

    @GetMapping("/{resource_id}/share/{share_id}")
    @Override
    public ResponseEntity<Share> findShareByIdAndResource(@PathVariable("resource_id") final Long resourceId,
                                                          @PathVariable("share_id") final Long shareId) {
        return null;
    }

    @PostMapping("/{resource_id}/share")
    @Override
    public ResponseEntity<Share> createShareInResource(@PathVariable("resource_id") final Long resourceId,
                                                       @Valid @RequestBody final CreateShareDto share) {
        return null;
    }

    @GetMapping("/{resource_id}/share-action/{share_action_id}")
    @Override
    public ResponseEntity<ShareAction> findShareActionByResource(@PathVariable("resource_id") final Long resourceId,
                                                                 @PathVariable("share_action_id") final Long shareActionId) {
        return null;
    }

    @PostMapping("/{resource_id}/share-action")
    @Override
    public ResponseEntity<ShareAction> shareResource(@PathVariable("resource_id") final Long resourceId,
                                                     @Valid @RequestBody final CreateShareActionDto shareAction) {
        return null;
    }

    @PutMapping("/{resource_id}/share-action")
    @Override
    public ResponseEntity<ShareAction> updateShareOfResource(@PathVariable("resource_id") final Long resourceId,
                                                             @Valid @RequestBody final UpdateShareActionDto shareAction) {
        return null;
    }

    @DeleteMapping("/{resource_id}/share/{share_id}/share-action/{share_action_id}")
    @Override
    public ResponseEntity<Void> deleteShareOfResource(@PathVariable("resource_id") final Long resourceId,
                                                      @PathVariable("share_id") final Long shareId,
                                                      @PathVariable("share_action_id") final Long shareActionId) {
        return null;
    }

    @DeleteMapping("/{resource_id}/share/{share_id}")
    @Override
    public ResponseEntity<Void> deleteAllShareActionsOfResource(@PathVariable("resource_id") final Long resourceId,
                                                                @PathVariable("share_id") final Long shareId) {
        return null;
    }
    //endregion

    //region Rates Operation

    @GetMapping("/{resource_id}/Scores")
    @Override
    public ResponseEntity<Score> findAllScoreRatesByResource(@PathVariable("resource_id") final Long resourceId) {
        return null;
    }

    @Override
    public ResponseEntity<Score> findScoreByIdAndResource(Long resourceId, Long scoreId) {
        return null;
    }

    @Override
    public ResponseEntity<Score> createScoreInResource(Long resourceId, CreateScoreDto score) {
        return null;
    }

    @Override
    public ResponseEntity<Rate> findScoreRateByResource(Long resourceId, Long rateId) {
        return null;
    }

    @Override
    public ResponseEntity<Rate> rateToResource(Long resourceId, CreateRateDto rate) {
        return null;
    }

    @Override
    public ResponseEntity<Rate> updateRateOfResource(Long resourceId, UpdateRateDto rate) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteRateOfResource(Long resourceId, Long scoreId, Long rateId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteAllRatesOfResource(Long resourceId, Long scoreId) {
        return null;
    }
    //endregion
}
