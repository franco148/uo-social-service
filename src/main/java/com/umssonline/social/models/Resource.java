package com.umssonline.social.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ResourceType type;

    @OneToOne(mappedBy = "resource")
    private Score score;
    @OneToMany(mappedBy = "resource")
    private Set<Share> shares;
    @OneToOne(mappedBy = "resource")
    private Comment comment;
}
