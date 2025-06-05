package com.smartworkflow.stoktakip.mapper;

import com.smartworkflow.stoktakip.dto.StokKartDto;
import com.smartworkflow.stoktakip.entity.StokKart;

public class StokKartMapper {

    public static StokKartDto toDto(StokKart entity) {
        if (entity == null) return null;

        StokKartDto dto = new StokKartDto();
        dto.setId(entity.getId());
        dto.setStokKodu(entity.getStokKodu());
        dto.setStokAdi(entity.getStokAdi());
        dto.setBirim(entity.getBirim());
        dto.setTur(entity.getTur());
        dto.setKdvOrani(entity.getKdvOrani());
        dto.setAciklama(entity.getAciklama());
        dto.setAktif(entity.getAktif());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setLastModifiedBy(entity.getLastModifiedBy());
        dto.setLastModifiedDate(entity.getLastModifiedDate());

        return dto;
    }

    public static StokKart toEntity(StokKartDto dto) {
        if (dto == null) return null;

        StokKart entity = new StokKart();
        entity.setId(dto.getId());
        entity.setStokKodu(dto.getStokKodu());
        entity.setStokAdi(dto.getStokAdi());
        entity.setBirim(dto.getBirim());
        entity.setTur(dto.getTur());
        entity.setKdvOrani(dto.getKdvOrani());
        entity.setAciklama(dto.getAciklama());
        entity.setAktif(dto.getAktif());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setLastModifiedBy(dto.getLastModifiedBy());
        entity.setLastModifiedDate(dto.getLastModifiedDate());

        return entity;
    }
}
