package com.smartworkflow.stoktakip.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "stok_kart")
@Data
public class StokKart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stok_kodu", nullable = false, unique = true)
    private String stokKodu;

    @Column(name = "stok_adi", nullable = false)
    private String stokAdi;

    private String birim;
    private String tur;

    @Column(name = "kdv_orani")
    private Double kdvOrani;

    private String aciklama;
    private Boolean aktif;

    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
}
