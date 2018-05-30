package com.umssonline.social.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    @Column(nullable = false)
    private Float rateAverage;
    @Column(nullable = false)
    private Integer numberOfRates;

    @OneToMany(mappedBy = "score")
    private Set<Rate> rates;
    @OneToOne(mappedBy = "score")
    private Resource resource;
}
