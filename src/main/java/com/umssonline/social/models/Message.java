package com.umssonline.social.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Message extends BaseEntity {

    @Column(nullable = false)
    private String text;

    @JsonBackReference
    @ManyToOne(optional = false)
    private Comment comment;
}
