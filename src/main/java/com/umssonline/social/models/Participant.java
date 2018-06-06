package com.umssonline.social.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@EqualsAndHashCode(exclude = {"shared", "sharedWithMe", "messages"})
@ToString(exclude = {"shared", "sharedWithMe", "messages"})
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
