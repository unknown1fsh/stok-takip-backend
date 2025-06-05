package com.smartworkflow.stoktakip.mapper;

import com.smartworkflow.stoktakip.dto.ParametreDto;
import com.smartworkflow.stoktakip.entity.Parametre;

public class ParametreMapper {

    public static ParametreDto toDto(Parametre entity) {
        if (entity == null) return null;

        ParametreDto dto = new ParametreDto();
        dto.setId(entity.getId());
        dto.setParametreKodu(entity.getParametreKodu());
        dto.setParametreAdi(entity.getParametreAdi());
        dto.setParametreDegeri(entity.getParametreDegeri());
        dto.setAktif(entity.getAktif());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setLastModifiedBy(entity.getLastModifiedBy());
        dto.setLastModifiedDate(entity.getLastModifiedDate());

        return dto;
    }

    public static Parametre toEntity(ParametreDto dto) {
        if (dto == null) return null;

        Parametre entity = new Parametre();
        entity.setId(dto.getId());
        entity.setParametreKodu(dto.getParametreKodu());
        entity.setParametreAdi(dto.getParametreAdi());
        entity.setParametreDegeri(dto.getParametreDegeri());
        entity.setAktif(dto.getAktif());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setLastModifiedBy(dto.getLastModifiedBy());
        entity.setLastModifiedDate(dto.getLastModifiedDate());

        return entity;
    }
}
