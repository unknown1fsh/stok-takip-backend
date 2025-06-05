package com.smartworkflow.stoktakip.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "depo")
@Data
public class Depo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "depo_kodu", nullable = false, unique = true)
    private String depoKodu;

    @Column(name = "depo_adi", nullable = false)
    private String depoAdi;

    private String sorumlu;

    private Boolean aktif;

    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
}
