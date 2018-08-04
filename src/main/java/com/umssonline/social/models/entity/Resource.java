package com.umssonline.social.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@EqualsAndHashCode(exclude = {"score", "share", "comment"})
@ToString(exclude = {"score", "share", "comment"})

@Entity
public class Resource {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ResourceType type;

    @JsonBackReference
    @OneToOne(mappedBy = "ratedResource", fetch = FetchType.LAZY)
    private Score score;
    @JsonBackReference
    @OneToOne(mappedBy = "sharedResource", fetch = FetchType.LAZY)
    private Share share;
    @JsonBackReference
    @OneToOne(mappedBy = "commentedResource", fetch = FetchType.LAZY)
    private Comment comment;
}
