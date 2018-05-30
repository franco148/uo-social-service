package com.umssonline.social.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class ShareAction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime sharedAt;

    @ManyToOne(optional = false)
    private Participant sharedWith;
    @ManyToOne(optional = false)
    private Participant sharedBy;

    @ManyToOne(optional = false)
    private Share share;
}
