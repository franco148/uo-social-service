package com.umssonline.social.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

//Soft delete
@SQLDelete(sql = "update share_actions set is_deleted=true where id=?")
//Conditions when retrieving data when it is not deleted
@Where(clause = "is_deleted=false")

@Data
@EqualsAndHashCode(exclude = {"sharedWith", "sharedBy", "share"}, callSuper = false)
@ToString(exclude = {"sharedWith", "sharedBy", "share"})

@Entity
@Table(name = "share_actions")
public class ShareAction extends BaseEntity {

    @JsonManagedReference
    @ManyToOne(optional = false)
    private Participant sharedWith;
    @JsonManagedReference
    @ManyToOne(optional = false)
    private Participant sharedBy;

    @JsonBackReference
    @ManyToOne(optional = false)
    private Share share;
}
