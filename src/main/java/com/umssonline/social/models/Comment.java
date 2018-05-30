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

    @OneToOne
    private Resource resource;
    @OneToMany
    private Set<Message> messages;
}
