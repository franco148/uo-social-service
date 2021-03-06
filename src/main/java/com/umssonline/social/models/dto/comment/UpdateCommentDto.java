package com.umssonline.social.models.dto.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Getter
@Setter
public class UpdateCommentDto {

    //@Id
    @NotNull
    private Long id;
    private Long updatedById;

    @JsonIgnore
    private LocalDateTime updatedAt = LocalDateTime.now();
}
