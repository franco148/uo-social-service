package com.umssonline.social.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonBackReference
    @OneToMany(mappedBy = "sharedBy")
    private Set<ShareAction> shared;
    @JsonBackReference
    @OneToMany(mappedBy = "sharedWith")
    private Set<ShareAction> sharedWithMe;
    @JsonBackReference
    @OneToMany(mappedBy = "createdBy")
    private Set<Message> messages;
}
