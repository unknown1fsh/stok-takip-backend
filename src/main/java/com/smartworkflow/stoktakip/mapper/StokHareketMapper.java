package com.smartworkflow.stoktakip.mapper;

import com.smartworkflow.stoktakip.dto.StokHareketDto;
import com.smartworkflow.stoktakip.entity.Depo;
import com.smartworkflow.stoktakip.entity.StokHareket;
import com.smartworkflow.stoktakip.entity.StokKart;

public class StokHareketMapper {

    public static StokHareketDto toDto(StokHareket entity) {
        if (entity == null) return null;

        StokHareketDto dto = new StokHareketDto();
        dto.setId(entity.getId());
        dto.setHareketTipi(entity.getHareketTipi());

        if (entity.getStokKart() != null) {
            dto.setStokKartId(entity.getStokKart().getId());
            dto.setStokKodu(entity.getStokKart().getStokKodu());
            dto.setStokAdi(entity.getStokKart().getStokAdi());
        }

        if (entity.getDepo() != null) {
            dto.setDepoId(entity.getDepo().getId());
            dto.setDepoAdi(entity.getDepo().getDepoAdi());
        }

        dto.setMiktar(entity.getMiktar());
        dto.setBirimFiyat(entity.getBirimFiyat());
        dto.setToplamTutar(entity.getToplamTutar());
        dto.setTarih(entity.getTarih());
        dto.setAciklama(entity.getAciklama());

        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setLastModifiedBy(entity.getLastModifiedBy());
        dto.setLastModifiedDate(entity.getLastModifiedDate());

        return dto;
    }

    public static StokHareket toEntity(StokHareketDto dto, StokKart stokKart, Depo depo) {
        if (dto == null) return null;

        StokHareket entity = new StokHareket();
        entity.setId(dto.getId());
        entity.setHareketTipi(dto.getHareketTipi());
        entity.setStokKart(stokKart);
        entity.setDepo(depo);
        entity.setMiktar(dto.getMiktar());
        entity.setBirimFiyat(dto.getBirimFiyat());
        entity.setToplamTutar(dto.getToplamTutar());
        entity.setTarih(dto.getTarih());
        entity.setAciklama(dto.getAciklama());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setLastModifiedBy(dto.getLastModifiedBy());
        entity.setLastModifiedDate(dto.getLastModifiedDate());

        return entity;
    }
}
