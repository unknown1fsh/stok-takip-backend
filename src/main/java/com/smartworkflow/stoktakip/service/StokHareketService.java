package com.smartworkflow.stoktakip.service;

import com.smartworkflow.stoktakip.dto.StokHareketDto;
import com.smartworkflow.stoktakip.enums.HareketTipi;

import java.util.List;

public interface StokHareketService {

    StokHareketDto save(StokHareketDto dto);

    StokHareketDto update(Long id, StokHareketDto dto);

    void delete(Long id);

    StokHareketDto getById(Long id);

    List<StokHareketDto> getAll();

    List<StokHareketDto> getByDepoId(Long depoId);

    List<StokHareketDto> getByStokKartId(Long stokKartId);

    List<StokHareketDto> getByHareketTipi(HareketTipi hareketTipi);

    boolean existsByStokKartId(Long stokKartId);

    void deleteAllByStokKartId(Long stokKartId);
}
