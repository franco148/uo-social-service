package com.umssonline.social.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseUpdateDto {

    @NotNull(message = "Id field should not be null.")
    @Positive(message = "Id field should not be less than zero.")
    private Long id;

    @JsonIgnore
    private LocalDateTime updatedAt = LocalDateTime.now();

    @JsonIgnore
    private Boolean isDeleted = false;


    @NotNull(message = "UpdatedById field should not be null.")
    @Positive(message = "UpdatedById field should not be less than zero.")
    private Long updatedById;
}
