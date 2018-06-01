package com.umssonline.social.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Score extends BaseEntity {

    @Column(nullable = false)
    private Float rateAverage;
    @Column(nullable = false)
    private Integer numberOfRates;

    @OneToMany(mappedBy = "score")
    private Set<Rate> rates;
    @OneToOne(optional = false)
    private Resource ratedResource;
}
