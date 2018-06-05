package com.umssonline.social.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Comment extends BaseEntity {

    @Column(nullable = false)
    private Integer messagesAmount;

    @JsonBackReference
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_Resource")
    private Resource commentedResource;
    @JsonManagedReference
    @OneToMany(mappedBy = "comment")
    private Set<Message> messages;
}
