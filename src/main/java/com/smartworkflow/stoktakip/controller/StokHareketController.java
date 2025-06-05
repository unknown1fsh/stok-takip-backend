package com.smartworkflow.stoktakip.controller;

import com.smartworkflow.stoktakip.dto.StokHareketDto;
import com.smartworkflow.stoktakip.enums.HareketTipi;
import com.smartworkflow.stoktakip.service.StokHareketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stok-hareket")
@RequiredArgsConstructor
public class StokHareketController {

    private final StokHareketService stokHareketService;

    @PostMapping
    public ResponseEntity<StokHareketDto> save(@RequestBody StokHareketDto dto) {
        return ResponseEntity.ok(stokHareketService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StokHareketDto> update(@PathVariable Long id, @RequestBody StokHareketDto dto) {
        return ResponseEntity.ok(stokHareketService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        stokHareketService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StokHareketDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(stokHareketService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<StokHareketDto>> getAll() {
        return ResponseEntity.ok(stokHareketService.getAll());
    }

    @GetMapping("/by-depo/{depoId}")
    public ResponseEntity<List<StokHareketDto>> getByDepoId(@PathVariable Long depoId) {
        return ResponseEntity.ok(stokHareketService.getByDepoId(depoId));
    }

    @GetMapping("/by-stok/{stokKartId}")
    public ResponseEntity<List<StokHareketDto>> getByStokKartId(@PathVariable Long stokKartId) {
        return ResponseEntity.ok(stokHareketService.getByStokKartId(stokKartId));
    }

    @GetMapping("/by-tip/{hareketTipi}")
    public ResponseEntity<List<StokHareketDto>> getByHareketTipi(@PathVariable HareketTipi hareketTipi) {
        return ResponseEntity.ok(stokHareketService.getByHareketTipi(hareketTipi));
    }

    @GetMapping("/existsByStokKartId/{stokKartId}")
    public ResponseEntity<Boolean> existsByStokKartId(@PathVariable Long stokKartId) {
        return ResponseEntity.ok(stokHareketService.existsByStokKartId(stokKartId));
    }

    @DeleteMapping("/by-stok/{stokKartId}")
    public ResponseEntity<Void> deleteAllByStokKartId(@PathVariable Long stokKartId) {
        stokHareketService.deleteAllByStokKartId(stokKartId);
        return ResponseEntity.noContent().build();
    }
}
