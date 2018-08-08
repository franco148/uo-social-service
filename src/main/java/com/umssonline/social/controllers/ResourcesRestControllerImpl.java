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
import com.umssonline.social.services.CommentService;
import com.umssonline.social.services.MessageService;
import com.umssonline.social.services.ResourceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/resources")
public class ResourcesRestControllerImpl implements ResourcesRestController {

    //region Properties

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private ModelMapper modelMapper;
    //endregion


    //region Comments Operations

    @GetMapping("/{resource_id}/comments")
    @Override
    public ResponseEntity<Comment> findAllCommentMessagesByResource(@PathVariable("resource_id") final Long resourceId) {
        Resource savedResource = resourceService.findById(resourceId);
        return ResponseEntity.status(HttpStatus.FOUND).body(savedResource.getComment());
    }

    @PostMapping("/{resource_id}/comment")
    @Override
    public ResponseEntity<Comment> createCommentInResource(@PathVariable("resource_id") final Long resourceId,
                                                           @Valid @RequestBody final CreateCommentDto comment) {
        comment.setCommentedResourceId(resourceId);

        Comment converted = modelMapper.map(comment, Comment.class);
        Comment saved = commentService.save(converted);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{resource_id}/message/{message_id}")
    @Override
    public ResponseEntity<Message> findCommentMessageByResource(@PathVariable("resource_id") final Long resourceId,
                                                                @PathVariable("message_id") final Long messageId) {
        Message foundMessage = messageService.findByIdAndResourceId(resourceId, messageId);
        return ResponseEntity.status(HttpStatus.FOUND).body(foundMessage);
    }

    @PostMapping("/{resource_id}/message")
    @Override
    public ResponseEntity<Message> createCommentMessageInResource(@PathVariable("resource_id") final Long resourceId,
                                                                  @Valid @RequestBody final CreateMessageDto message) {
        Message converted = modelMapper.map(message, Message.class);
        Message saved = messageService.save(converted);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{resource_id}/message")
    @Override
    public ResponseEntity<Message> updateCommentMessageOfResource(@PathVariable("resource_id") final Long resourceId,
                                                                  @Valid @RequestBody final UpdateMessageDto message) {

        Message converted = modelMapper.map(message, Message.class);
        Message updated = messageService.update(converted);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{resource_id}/comment/{comment_id}")
    @Override
    public ResponseEntity<Void> deleteAllCommentMessagesOfResource(@PathVariable("resource_id") final Long resourceId,
                                                                   @PathVariable("comment_id") final Long commentId) {
        //commentService.deleteById(commentId);
        commentService.deleteMessagesByResourceIdAndCommentId(resourceId, commentId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{resource_id}/comment/{comment_id}/message/{message_id}")
    @Override
    public ResponseEntity<Void> deleteCommentMessageOfResource(@PathVariable("resource_id") final Long resourceId,
                                                               @PathVariable("comment_id") final Long commentId,
                                                               @PathVariable("message_id") final Long messageId) {

        messageService.deleteMessageByIdFromCommentAndResource(messageId, commentId, resourceId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{resource_id}/comment/{comment_id}")
    @Override
    public ResponseEntity<Comment> findCommentByIdAndResource(@PathVariable("resource_id") final Long resourceId,
                                                              @PathVariable("comment_id") final Long commentId) {
        Comment foundComment = commentService.findById(commentId);
        return ResponseEntity.status(HttpStatus.FOUND).body(foundComment);
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

    @GetMapping("/{resource_id}/score/{score_id}")
    @Override
    public ResponseEntity<Score> findScoreByIdAndResource(@PathVariable("resource_id") final Long resourceId,
                                                          @PathVariable("score_id") final Long scoreId) {
        return null;
    }

    @PostMapping("/{resource_id}/score")
    @Override
    public ResponseEntity<Score> createScoreInResource(@PathVariable("resource_id") final Long resourceId,
                                                       @Valid @RequestBody final CreateScoreDto score) {
        return null;
    }

    @GetMapping("/{resource_id}/rate/{rate_id}")
    @Override
    public ResponseEntity<Rate> findScoreRateByResource(@PathVariable("resource_id") final Long resourceId,
                                                        @PathVariable("rate_id") final Long rateId) {
        return null;
    }

    @PostMapping("/{resource_id}/rate")
    @Override
    public ResponseEntity<Rate> rateToResource(@PathVariable("resource_id") final Long resourceId,
                                               @Valid @RequestBody final CreateRateDto rate) {
        return null;
    }

    @PutMapping("/{resource_id}/rate")
    @Override
    public ResponseEntity<Rate> updateRateOfResource(@PathVariable("resource_id") final Long resourceId,
                                                     @Valid @RequestBody final UpdateRateDto rate) {
        return null;
    }

    @DeleteMapping("/{resource_id}/score/{score_id}/rate/{rate_id}")
    @Override
    public ResponseEntity<Void> deleteRateOfResource(@PathVariable("resource_id") final Long resourceId,
                                                     @PathVariable("score_id") final Long scoreId,
                                                     @PathVariable("rate_id") final Long rateId) {
        return null;
    }

    @DeleteMapping("/{resource_id}/score/{score_id}")
    @Override
    public ResponseEntity<Void> deleteAllRatesOfResource(@PathVariable("resource_id") final Long resourceId,
                                                         @PathVariable("score_id") final Long scoreId) {
        return null;
    }
    //endregion
}
