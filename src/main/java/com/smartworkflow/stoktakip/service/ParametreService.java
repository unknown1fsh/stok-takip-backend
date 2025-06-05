package com.smartworkflow.stoktakip.service;

import com.smartworkflow.stoktakip.dto.ParametreDto;

import java.util.List;

public interface ParametreService {

    ParametreDto save(ParametreDto dto);

    ParametreDto update(Long id, ParametreDto dto);

    void delete(Long id);

    ParametreDto getById(Long id);

    List<ParametreDto> getAll();

    ParametreDto getByKodu(String kod);

    boolean existsByKodu(String kod);
}
