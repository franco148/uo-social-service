package com.umssonline.social.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
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
