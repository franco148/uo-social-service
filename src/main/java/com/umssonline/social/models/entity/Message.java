package com.umssonline.social.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = "comment", callSuper = false)
@ToString(exclude = "comment")

@Entity
public class Message extends BaseEntity {

    @Column(nullable = false)
    private String text;

    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Comment comment;
}
