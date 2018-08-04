package com.umssonline.social.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(exclude = {"commentedResource", "messages"}, callSuper = false)
@ToString(exclude = {"commentedResource", "messages"})
@Data

@Entity
public class Comment extends BaseEntity {

    @Column(nullable = false)
    private Integer messagesAmount;

    @JsonManagedReference
    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "FK_Resource")
    private Resource commentedResource;
    @JsonManagedReference
    @OneToMany(mappedBy = "comment")
    private Set<Message> messages;
}
