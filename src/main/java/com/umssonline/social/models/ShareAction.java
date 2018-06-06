package com.umssonline.social.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"sharedWith", "sharedBy", "share"}, callSuper = false)
@ToString(exclude = {"sharedWith", "sharedBy", "share"})

@Entity
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
