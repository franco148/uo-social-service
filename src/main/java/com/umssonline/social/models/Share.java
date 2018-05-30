package com.umssonline.social.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Share {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private Integer sharingAmount;

    @OneToOne(optional = false)
    private Resource sharedResource;
    @OneToMany(mappedBy = "share")
    private Set<ShareAction> shareActions;
}
