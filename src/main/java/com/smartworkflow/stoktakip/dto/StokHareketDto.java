package com.smartworkflow.stoktakip.dto;

import com.smartworkflow.stoktakip.enums.HareketTipi;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class StokHareketDto {

    private Long id;

    private HareketTipi hareketTipi;

    private Long stokKartId;
    private String stokKodu;
    private String stokAdi;

    private Long depoId;
    private String depoAdi;

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
