package com.umssonline.social.models.dto.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.umssonline.social.models.dto.BaseCreateDto;
import com.umssonline.social.models.entity.ResourceType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateCommentDto extends BaseCreateDto {

//    @NotNull(message = "CommentedResourceId field should not be null.")
//    @Positive(message = "CommentedResourceId field should not be less than zero.")
    @JsonIgnore
    private Long commentedResourceId;

    @NotNull(message = "commentedResourceType field should not be null.")
    private ResourceType commentedResourceType;

    @JsonIgnore
    private Integer messagesAmount = 0;

}
