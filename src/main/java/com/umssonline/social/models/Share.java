package com.umssonline.social.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Share {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private Integer sharingAmount;

    @ManyToOne(optional = false)
    private Resource resource;
    @ManyToOne(optional = false)
    private Participant participant;
}
