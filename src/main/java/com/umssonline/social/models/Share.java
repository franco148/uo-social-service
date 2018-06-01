package com.umssonline.social.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Share extends BaseEntity {

    @Column(nullable = false)
    private Integer sharingAmount;

    @OneToOne(optional = false)
    private Resource sharedResource;
    @OneToMany(mappedBy = "share")
    private Set<ShareAction> shareActions;
}
