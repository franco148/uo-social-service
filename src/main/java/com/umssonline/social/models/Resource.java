package com.umssonline.social.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ResourceType type;

    @OneToOne
    private Score score;
}
