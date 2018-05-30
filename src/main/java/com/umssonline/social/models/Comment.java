package com.umssonline.social.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Comment extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Long id;
    @Column(nullable = false)
    private Integer messagesAmount;

    @OneToOne(optional = false)
    private Resource commentedResource;
    @OneToMany(mappedBy = "comment")
    private Set<Message> messages;
}
