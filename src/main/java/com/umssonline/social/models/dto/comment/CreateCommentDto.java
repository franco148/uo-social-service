package com.umssonline.social.models.dto.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.umssonline.social.models.dto.BaseCreateDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateCommentDto extends BaseCreateDto {

    @NotNull(message = "CommentedResourceId field should not be null.")
    @Negative(message = "CommentedResourceId field shoul not be less than zero.")
    private Long commentedResourceId;

    @JsonIgnore
    private Integer messagesAmount = 0;

}
