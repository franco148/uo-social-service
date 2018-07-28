package com.umssonline.social.models.dto.rate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.umssonline.social.models.dto.BaseCreateDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class CreateScoreDto extends BaseCreateDto {

    @JsonIgnore
    private Float rateAverage = 0f;
    @JsonIgnore
    private Integer numberOfRates = 0;

    @NotNull(message = "RatedResourceId field should not be null.")
    @Positive(message = "RatedResourceId field should not be less than zero.")
    private Long ratedResourceId;
}
