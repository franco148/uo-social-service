package com.umssonline.social.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "sharedBy")
    private Set<ShareAction> shared;
    @OneToMany(mappedBy = "sharedWith")
    private Set<ShareAction> sharedWithMe;
    @OneToMany(mappedBy = "createdBy")
    private Set<Message> messages;
}
