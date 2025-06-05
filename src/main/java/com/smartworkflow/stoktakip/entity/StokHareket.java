package com.smartworkflow.stoktakip.entity;

import com.smartworkflow.stoktakip.enums.HareketTipi;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "stok_hareket")
@Data
public class StokHareket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "hareket_tipi", nullable = false)
    private HareketTipi hareketTipi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stok_kart_id", nullable = false)
    private StokKart stokKart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "depo_id", nullable = false)
    private Depo depo;

    private Long miktar;
    private BigDecimal birimFiyat;
    private BigDecimal toplamTutar;
    private LocalDateTime tarih;
    private String aciklama;

    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
}
