package com.umssonline.social.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"rates", "ratedResource"}, callSuper = false)
@ToString(exclude = {"rates", "ratedResource"})

@Entity
public class Score extends BaseEntity {

    @Column(nullable = false)
    private Float rateAverage;
    @Column(nullable = false)
    private Integer numberOfRates;

    @JsonManagedReference
    @OneToMany(mappedBy = "score")
    private Set<Rate> rates;
    @JsonManagedReference
    @OneToOne(optional = false)
    private Resource ratedResource;
}
