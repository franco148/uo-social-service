package com.umssonline.social.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@EqualsAndHashCode(callSuper = true, exclude = "commentedResource")
@EqualsAndHashCode(exclude = "commentedResource", callSuper = false)
@ToString(exclude = "commentedResource")
@Data
//@Getter
//@Setter
@Entity
public class Comment extends BaseEntity {

    @Column(nullable = false)
    private Integer messagesAmount;

    //@JsonBackReference
    @JsonManagedReference
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_Resource")
    private Resource commentedResource;
    @JsonManagedReference
    @OneToMany(mappedBy = "comment")
    private Set<Message> messages;
}
