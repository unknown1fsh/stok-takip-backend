package com.smartworkflow.stoktakip.mapper;

import com.smartworkflow.stoktakip.dto.DepoDto;
import com.smartworkflow.stoktakip.entity.Depo;

public class DepoMapper {

    public static DepoDto toDto(Depo entity) {
        if (entity == null) return null;

        DepoDto dto = new DepoDto();
        dto.setId(entity.getId());
        dto.setDepoKodu(entity.getDepoKodu());
        dto.setDepoAdi(entity.getDepoAdi());
        dto.setSorumlu(entity.getSorumlu());
        dto.setAktif(entity.getAktif());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setLastModifiedBy(entity.getLastModifiedBy());
        dto.setLastModifiedDate(entity.getLastModifiedDate());

        return dto;
    }

    public static Depo toEntity(DepoDto dto) {
        if (dto == null) return null;

        Depo entity = new Depo();
        entity.setId(dto.getId());
        entity.setDepoKodu(dto.getDepoKodu());
        entity.setDepoAdi(dto.getDepoAdi());
        entity.setSorumlu(dto.getSorumlu());
        entity.setAktif(dto.getAktif());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setLastModifiedBy(dto.getLastModifiedBy());
        entity.setLastModifiedDate(dto.getLastModifiedDate());

        return entity;
    }
}
