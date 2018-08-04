package com.umssonline.social.models.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

//Soft delete
@SQLDelete(sql = "update shares set is_deleted=true where id=?")
//Conditions when retrieving data when it is not deleted
@Where(clause = "is_deleted=false")

@Data
@EqualsAndHashCode(exclude = {"sharedResource", "shareActions"}, callSuper = false)
@ToString(exclude = {"sharedResource", "shareActions"})

@Entity
@Table(name = "shares")
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
