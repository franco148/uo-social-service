package com.umssonline.social.models.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

//Soft delete
@SQLDelete(sql = "update scores set is_deleted=true where id=?")
//Conditions when retrieving data when it is not deleted
@Where(clause = "is_deleted=false")

@Data
@EqualsAndHashCode(exclude = {"rates", "ratedResource"}, callSuper = false)
@ToString(exclude = {"rates", "ratedResource"})

@Entity
@Table(name = "scores")
public class Score extends BaseEntity {

    @Column(nullable = false)
    private Float rateAverage;
    @Column(nullable = false)
    private Integer numberOfRates;

    @JsonManagedReference
    @OneToMany(mappedBy = "score")
    private Set<Rate> rates;
    @JsonManagedReference
    @OneToOne(optional = false)
    private Resource ratedResource;
}
