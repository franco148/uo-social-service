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

    @OneToOne(mappedBy = "ratedResource")
    private Score score;
    @OneToOne(mappedBy = "sharedResource")
    private Share share;
    @OneToOne(mappedBy = "commentedResource")
    private Comment comment;
}
