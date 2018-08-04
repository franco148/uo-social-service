package com.umssonline.social.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

//Soft delete
@SQLDelete(sql = "update rates set is_deleted=true where id=?")
//Conditions when retrieving data when it is not deleted
@Where(clause = "is_deleted=false")

@Data
@EqualsAndHashCode(exclude = "score", callSuper = false)
@ToString(exclude = "score")

@Entity
@Table(name = "rates")
public class Rate extends BaseEntity {

    @Column(nullable = false)
    private Float value;

    @JsonBackReference
    @ManyToOne(optional = false)
    private Score score;
}
