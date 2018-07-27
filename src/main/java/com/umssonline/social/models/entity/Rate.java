package com.umssonline.social.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = "score", callSuper = false)
@ToString(exclude = "score")

@Entity
public class Rate extends BaseEntity {

    @Column(nullable = false)
    private Float value;

    @JsonBackReference
    @ManyToOne(optional = false)
    private Score score;
}
