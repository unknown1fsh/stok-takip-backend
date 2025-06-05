package com.smartworkflow.stoktakip.service.impl;

import com.smartworkflow.stoktakip.dto.ParametreDto;
import com.smartworkflow.stoktakip.entity.Parametre;
import com.smartworkflow.stoktakip.exception.ResourceNotFoundException;
import com.smartworkflow.stoktakip.mapper.ParametreMapper;
import com.smartworkflow.stoktakip.repository.ParametreRepository;
import com.smartworkflow.stoktakip.service.ParametreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParametreServiceImpl implements ParametreService {

    private final ParametreRepository parametreRepository;

    @Override
    @Transactional
    public ParametreDto save(ParametreDto dto) {
        Parametre entity = ParametreMapper.toEntity(dto);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setAktif(true);
        return ParametreMapper.toDto(parametreRepository.save(entity));
    }

    @Override
    @Transactional
    public ParametreDto update(Long id, ParametreDto dto) {
        Parametre existing = parametreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Parametre bulunamadı. ID: " + id));

        existing.setParametreAdi(dto.getParametreAdi());
        existing.setParametreDegeri(dto.getParametreDegeri());
        existing.setAktif(dto.getAktif());
        existing.setLastModifiedDate(LocalDateTime.now());

        return ParametreMapper.toDto(parametreRepository.save(existing));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!parametreRepository.existsById(id)) {
            throw new ResourceNotFoundException("Parametre bulunamadı. ID: " + id);
        }
        parametreRepository.deleteById(id);
    }

    @Override
    public ParametreDto getById(Long id) {
        return parametreRepository.findById(id)
                .map(ParametreMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Parametre bulunamadı. ID: " + id));
    }

    @Override
    public List<ParametreDto> getAll() {
        return parametreRepository.findAll()
                .stream()
                .map(ParametreMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ParametreDto getByKodu(String kod) {
        return parametreRepository.findByParametreKodu(kod)
                .map(ParametreMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Parametre bulunamadı. Kodu: " + kod));
    }

    @Override
    public boolean existsByKodu(String kod) {
        return parametreRepository.existsByParametreKodu(kod);
    }
}
