package com.smartworkflow.stoktakip.service.impl;

import com.smartworkflow.stoktakip.dto.StokKartDto;
import com.smartworkflow.stoktakip.entity.StokKart;
import com.smartworkflow.stoktakip.exception.BusinessException;
import com.smartworkflow.stoktakip.exception.ResourceNotFoundException;
import com.smartworkflow.stoktakip.mapper.StokKartMapper;
import com.smartworkflow.stoktakip.repository.StokHareketRepository;
import com.smartworkflow.stoktakip.repository.StokKartRepository;
import com.smartworkflow.stoktakip.service.StokKartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StokKartServiceImpl implements StokKartService {

    private final StokKartRepository stokKartRepository;
    private final StokHareketRepository stokHareketRepository;

    @Override
    @Transactional
    public StokKartDto save(StokKartDto dto) {
        StokKart entity = StokKartMapper.toEntity(dto);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setAktif(true);
        return StokKartMapper.toDto(stokKartRepository.save(entity));
    }

    @Override
    @Transactional
    public StokKartDto update(Long id, StokKartDto dto) {
        StokKart existing = stokKartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stok kart bulunamadı. ID: " + id));
        existing.setStokAdi(dto.getStokAdi());
        existing.setBirim(dto.getBirim());
        existing.setTur(dto.getTur());
        existing.setKdvOrani(dto.getKdvOrani());
        existing.setAciklama(dto.getAciklama());
        existing.setAktif(dto.getAktif());
        existing.setLastModifiedDate(LocalDateTime.now());
        return StokKartMapper.toDto(stokKartRepository.save(existing));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        StokKart stokKart = stokKartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stok kart bulunamadı. ID: " + id));

        boolean hareketVar = stokHareketRepository.existsByStokKart_Id(id);
        if (hareketVar) {
            throw new BusinessException("Bu stok kartına ait hareket kaydı bulunduğundan silinemez.");
        }

        stokKartRepository.delete(stokKart);
    }

    @Override
    public StokKartDto getById(Long id) {
        return stokKartRepository.findById(id)
                .map(StokKartMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Stok kart bulunamadı. ID: " + id));
    }

    @Override
    public List<StokKartDto> getAll() {
        return stokKartRepository.findAll()
                .stream()
                .map(StokKartMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByStokKodu(String stokKodu) {
        return stokKartRepository.existsByStokKodu(stokKodu);
    }

    @Override
    public void updateAktifDurum(Long id, boolean aktif) {
        StokKart stokKart = stokKartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stok kart bulunamadı!"));
        stokKart.setAktif(aktif);
        stokKartRepository.save(stokKart);
    }
}
