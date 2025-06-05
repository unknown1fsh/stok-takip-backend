package com.smartworkflow.stoktakip.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "parametre")
@Data
public class Parametre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parametre_kodu", nullable = false, unique = true)
    private String parametreKodu;

    private String parametreAdi;

    private String parametreDegeri;

    private Boolean aktif;

    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
}
