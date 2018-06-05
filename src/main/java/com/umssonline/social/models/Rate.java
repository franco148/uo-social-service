package com.umssonline.social.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Rate extends BaseEntity {

    @Column(nullable = false)
    private Float value;

    @JsonBackReference
    @ManyToOne(optional = false)
    private Score score;
}
