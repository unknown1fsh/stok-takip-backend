package com.smartworkflow.stoktakip.service.impl;

import com.smartworkflow.stoktakip.dto.StokHareketDto;
import com.smartworkflow.stoktakip.entity.Depo;
import com.smartworkflow.stoktakip.entity.StokHareket;
import com.smartworkflow.stoktakip.entity.StokKart;
import com.smartworkflow.stoktakip.enums.HareketTipi;
import com.smartworkflow.stoktakip.exception.ResourceNotFoundException;
import com.smartworkflow.stoktakip.mapper.StokHareketMapper;
import com.smartworkflow.stoktakip.repository.DepoRepository;
import com.smartworkflow.stoktakip.repository.StokHareketRepository;
import com.smartworkflow.stoktakip.repository.StokKartRepository;
import com.smartworkflow.stoktakip.service.StokHareketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StokHareketServiceImpl implements StokHareketService {

    private final StokHareketRepository stokHareketRepository;
    private final StokKartRepository stokKartRepository;
    private final DepoRepository depoRepository;

    @Override
    @Transactional
    public StokHareketDto save(StokHareketDto dto) {
        StokKart stokKart = stokKartRepository.findById(dto.getStokKartId())
                .orElseThrow(() -> new ResourceNotFoundException("Stok kart bulunamadı. ID: " + dto.getStokKartId()));
        Depo depo = depoRepository.findById(dto.getDepoId())
                .orElseThrow(() -> new ResourceNotFoundException("Depo bulunamadı. ID: " + dto.getDepoId()));

        StokHareket entity = StokHareketMapper.toEntity(dto, stokKart, depo);
        entity.setCreatedDate(LocalDateTime.now());

        return StokHareketMapper.toDto(stokHareketRepository.save(entity));
    }

    @Override
    @Transactional
    public StokHareketDto update(Long id, StokHareketDto dto) {
        StokHareket existing = stokHareketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stok hareket kaydı bulunamadı. ID: " + id));

        StokKart stokKart = stokKartRepository.findById(dto.getStokKartId())
                .orElseThrow(() -> new ResourceNotFoundException("Stok kart bulunamadı. ID: " + dto.getStokKartId()));
        Depo depo = depoRepository.findById(dto.getDepoId())
                .orElseThrow(() -> new ResourceNotFoundException("Depo bulunamadı. ID: " + dto.getDepoId()));

        existing.setHareketTipi(dto.getHareketTipi());
        existing.setStokKart(stokKart);
        existing.setDepo(depo);
        existing.setMiktar(dto.getMiktar());
        existing.setBirimFiyat(dto.getBirimFiyat());
        existing.setToplamTutar(dto.getToplamTutar());
        existing.setTarih(dto.getTarih());
        existing.setAciklama(dto.getAciklama());
        existing.setLastModifiedDate(LocalDateTime.now());

        return StokHareketMapper.toDto(stokHareketRepository.save(existing));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!stokHareketRepository.existsById(id)) {
            throw new ResourceNotFoundException("Stok hareket kaydı bulunamadı. ID: " + id);
        }
        stokHareketRepository.deleteById(id);
    }

    @Override
    public StokHareketDto getById(Long id) {
        return stokHareketRepository.findById(id)
                .map(StokHareketMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Stok hareket kaydı bulunamadı. ID: " + id));
    }

    @Override
    public List<StokHareketDto> getAll() {
        return stokHareketRepository.findAll()
                .stream()
                .map(StokHareketMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StokHareketDto> getByDepoId(Long depoId) {
        return stokHareketRepository.findByDepo_Id(depoId)
                .stream()
                .map(StokHareketMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StokHareketDto> getByStokKartId(Long stokKartId) {
        return stokHareketRepository.findByStokKart_Id(stokKartId)
                .stream()
                .map(StokHareketMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StokHareketDto> getByHareketTipi(HareketTipi hareketTipi) {
        return stokHareketRepository.findByHareketTipi(hareketTipi)
                .stream()
                .map(StokHareketMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByStokKartId(Long stokKartId) {
        return stokHareketRepository.existsByStokKart_Id(stokKartId);
    }

    @Override
    @Transactional
    public void deleteAllByStokKartId(Long stokKartId) {
        List<StokHareket> hareketler = stokHareketRepository.findByStokKart_Id(stokKartId);
        stokHareketRepository.deleteAll(hareketler);
    }
}
