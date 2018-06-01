package com.umssonline.social.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateCommentDto {

    private Long commentedResourceId;
    private Long createdById;

    @JsonIgnore
    private LocalDateTime createdAt = LocalDateTime.now();
    @JsonIgnore
    private LocalDateTime updatedAt = LocalDateTime.now();
}
