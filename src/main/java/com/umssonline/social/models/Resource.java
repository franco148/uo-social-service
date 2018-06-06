package com.umssonline.social.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(exclude = "comment")
@ToString(exclude = "comment")
@Data
//@Getter
//@Setter
@Entity
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ResourceType type;

    @JsonBackReference
    @OneToOne(mappedBy = "ratedResource")
    private Score score;
    @JsonBackReference
    @OneToOne(mappedBy = "sharedResource")
    private Share share;
    //@JsonBackReference
    @JsonIgnore
    @OneToOne(mappedBy = "commentedResource", fetch = FetchType.LAZY)
    private Comment comment;
}
