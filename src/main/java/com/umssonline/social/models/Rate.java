package com.umssonline.social.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private Float value;

    @ManyToOne(optional = false)
    private Score score;
}
