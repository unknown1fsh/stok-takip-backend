package com.smartworkflow.stoktakip.service;

import com.smartworkflow.stoktakip.dto.StokKartDto;

import java.util.List;

public interface StokKartService {

    StokKartDto save(StokKartDto dto);

    StokKartDto update(Long id, StokKartDto dto);

    void delete(Long id);

    StokKartDto getById(Long id);

    List<StokKartDto> getAll();

    boolean existsByStokKodu(String stokKodu);

    void updateAktifDurum(Long id, boolean aktif);
}
