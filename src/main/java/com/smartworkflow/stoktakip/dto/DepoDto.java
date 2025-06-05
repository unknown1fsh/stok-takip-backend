package com.smartworkflow.stoktakip.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DepoDto {

    private Long id;
    private String depoKodu;
    private String depoAdi;
    private String sorumlu;
    private Boolean aktif;
    private String aciklama;


    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
}
