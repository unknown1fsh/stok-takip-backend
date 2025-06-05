package com.smartworkflow.stoktakip.service.impl;

import com.smartworkflow.stoktakip.dto.DepoDto;
import com.smartworkflow.stoktakip.entity.Depo;
import com.smartworkflow.stoktakip.exception.BusinessException;
import com.smartworkflow.stoktakip.exception.ResourceNotFoundException;
import com.smartworkflow.stoktakip.mapper.DepoMapper;
import com.smartworkflow.stoktakip.repository.DepoRepository;
import com.smartworkflow.stoktakip.repository.StokHareketRepository;
import com.smartworkflow.stoktakip.service.DepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepoServiceImpl implements DepoService {

    private final DepoRepository depoRepository;
    private final StokHareketRepository stokHareketRepository;

    @Override
    @Transactional
    public DepoDto save(DepoDto dto) {
        Depo entity = DepoMapper.toEntity(dto);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setAktif(true);
        return DepoMapper.toDto(depoRepository.save(entity));
    }

    @Override
    @Transactional
    public DepoDto update(Long id, DepoDto dto) {
        Depo existing = depoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Depo bulunamadı. ID: " + id));
        existing.setDepoAdi(dto.getDepoAdi());
        existing.setSorumlu(dto.getSorumlu());
        existing.setAktif(dto.getAktif());
        existing.setLastModifiedDate(LocalDateTime.now());
        return DepoMapper.toDto(depoRepository.save(existing));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!depoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Depo bulunamadı. ID: " + id);
        }

        Long hareketSayisi = stokHareketRepository.countByDepoId(id);
        if (hareketSayisi != null && hareketSayisi > 0) {
            throw new BusinessException("Bu depoya ait stok hareketi bulunduğu için silinemez.");
        }

        depoRepository.deleteById(id);
    }

    @Override
    public DepoDto getById(Long id) {
        return depoRepository.findById(id)
                .map(DepoMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Depo bulunamadı. ID: " + id));
    }

    @Override
    public List<DepoDto> getAll() {
        return depoRepository.findAll()
                .stream()
                .map(DepoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByDepoKodu(String depoKodu) {
        return depoRepository.existsByDepoKodu(depoKodu);
    }
}
