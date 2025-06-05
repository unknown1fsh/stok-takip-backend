package com.smartworkflow.stoktakip.service;

import com.smartworkflow.stoktakip.dto.DepoDto;

import java.util.List;

public interface DepoService {

    DepoDto save(DepoDto dto);

    DepoDto update(Long id, DepoDto dto);

    void delete(Long id);

    DepoDto getById(Long id);

    List<DepoDto> getAll();

    boolean existsByDepoKodu(String depoKodu);
}
