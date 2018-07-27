package com.umssonline.social.models.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"sharedResource", "shareActions"}, callSuper = false)
@ToString(exclude = {"sharedResource", "shareActions"})

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