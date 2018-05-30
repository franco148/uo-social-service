package com.umssonline.social.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


public class UpdateCommentDto {

    @Id
    @NotNull
    private Long id;
    private Long updatedById;

    @JsonIgnore
    private LocalDateTime updatedAt = LocalDateTime.now();
}
