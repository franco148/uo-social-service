package com.umssonline.social.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference
    @OneToOne(optional = false)
    private Resource sharedResource;
    @JsonManagedReference
    @OneToMany(mappedBy = "share")
    private Set<ShareAction> shareActions;
}
