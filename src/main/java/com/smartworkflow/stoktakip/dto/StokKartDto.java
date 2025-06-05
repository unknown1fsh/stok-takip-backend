package com.smartworkflow.stoktakip.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StokKartDto {

    private Long id;
    private String stokKodu;
    private String stokAdi;
    private String birim;
    private String tur;
    private Double kdvOrani;
    private String aciklama;
    private Boolean aktif;

    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
}
