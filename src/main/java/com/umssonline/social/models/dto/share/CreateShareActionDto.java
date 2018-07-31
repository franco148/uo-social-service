package com.umssonline.social.models.dto.share;

import com.umssonline.social.models.dto.BaseCreateDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class CreateShareActionDto extends BaseCreateDto {

    @NotNull(message = "SharedWithId field should not be null.")
    @Positive(message = "SharedWithId field should not be less than zero.")
    private Long sharedWithId;

    @NotNull(message = "SharedById field should not be null.")
    @Positive(message = "SharedById field should not be less than zero.")
    private Long sharedById;

    @NotNull(message = "ShareId field should not be null.")
    @Positive(message = "ShareId field should not be less than zero.")
    private Long shareId;
}
