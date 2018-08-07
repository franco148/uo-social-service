package com.umssonline.social.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

//Soft delete
@SQLDelete(sql = "update comments set is_deleted=true where id=?")
//Conditions when retrieving data when it is not deleted
@Where(clause = "is_deleted=false")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(exclude = {"commentedResource", "messages"}, callSuper = false)
@ToString(exclude = {"commentedResource", "messages"})
@Data

@Entity
@Table(name = "comments")
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
