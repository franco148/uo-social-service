package com.umssonline.social.models.dto.comment;

import com.umssonline.social.models.dto.BaseCreateDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class CreateMessageDto extends BaseCreateDto {

    @NotBlank(message = "Text field should not be null or empty.")
    private String text;

    @NotNull(message = "CommentId field should not be null.")
    @Positive(message = "CommentId field should not be less than zero.")
    private Long commentId;
}
