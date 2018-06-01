package com.umssonline.social.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class ShareAction extends BaseEntity {

    @ManyToOne(optional = false)
    private Participant sharedWith;
    @ManyToOne(optional = false)
    private Participant sharedBy;

    @ManyToOne(optional = false)
    private Share share;
}
