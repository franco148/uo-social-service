package com.umssonline.social.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

//Soft delete
@SQLDelete(sql = "update messages set is_deleted=true where id=?")
//Conditions when retrieving data when it is not deleted
@Where(clause = "is_deleted=false")

@Data
@EqualsAndHashCode(exclude = "comment", callSuper = false)
@ToString(exclude = "comment")

@Entity
@Table(name = "messages")
public class Message extends BaseEntity {

    @Column(nullable = false)
    private String text;

    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Comment comment;
}
