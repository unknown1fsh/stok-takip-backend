package com.smartworkflow.stoktakip.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ParametreDto {

    private Long id;
    private String parametreKodu;
    private String parametreAdi;
    private String parametreDegeri;
    private Boolean aktif;
    private String aciklama;


    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
}
