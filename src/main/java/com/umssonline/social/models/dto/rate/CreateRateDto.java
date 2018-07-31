package com.umssonline.social.models.dto.rate;

import com.umssonline.social.models.dto.BaseCreateDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class CreateRateDto extends BaseCreateDto {

    @NotNull(message = "Value field should not be null.")
    @Positive(message = "Value field should not be less than zero.")
    private Float value;

    @NotNull(message = "ScoreId field should not be null.")
    @Positive(message = "ScoreId field should not be less than zero.")
    private Long scoreId;
}
