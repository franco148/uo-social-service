package com.umssonline.social.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseCreateDto {

    @JsonIgnore
    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    private LocalDateTime updatedAt = LocalDateTime.now();

    @JsonIgnore
    private Boolean isDeleted = false;


    @NotNull(message = "CreatedById field should not be null.")
    @Positive(message = "CreatedById field should not be less than zero.")
    private Long createdById;
}
