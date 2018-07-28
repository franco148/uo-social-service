package com.umssonline.social.models.dto.share;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.umssonline.social.models.dto.BaseCreateDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class CreateShareDto extends BaseCreateDto {

    @JsonIgnore
    private Integer sharingAmount;

    @NotNull(message = "SharedResourceId field should not be null.")
    @Positive(message = "SharedResourceId field should not be less than zero.")
    private Long sharedResourceId;
}
