package com.umssonline.social.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Message extends BaseEntity {

    @Column(nullable = false)
    private String text;

    @ManyToOne(optional = false)
    private Comment comment;
}
