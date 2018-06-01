package com.umssonline.social.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Column(nullable = false)
    private Boolean isDeleted;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_CreatedBy")
    private Participant createdBy;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_UpdatedBy")
    private Participant updatedBy;
}
