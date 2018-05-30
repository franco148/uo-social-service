package com.umssonline.social.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private Integer messagesAmount;

    @OneToOne(optional = false)
    private Resource commentedResource;
    @OneToMany(mappedBy = "comment")
    private Set<Message> messages;
}
