package com.smartworkflow.stoktakip.controller;

import com.smartworkflow.stoktakip.dto.StokKartDto;
import com.smartworkflow.stoktakip.service.StokKartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/stok-kart")
@RequiredArgsConstructor
public class StokKartController {

    private final StokKartService stokKartService;

    @PostMapping
    public ResponseEntity<StokKartDto> save(@RequestBody StokKartDto dto) {
        return ResponseEntity.ok(stokKartService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StokKartDto> update(@PathVariable Long id, @RequestBody StokKartDto dto) {
        return ResponseEntity.ok(stokKartService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        stokKartService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StokKartDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(stokKartService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<StokKartDto>> getAll() {
        return ResponseEntity.ok(stokKartService.getAll());
    }

    @GetMapping("/exists/{stokKodu}")
    public ResponseEntity<Boolean> existsByStokKodu(@PathVariable String stokKodu) {
        return ResponseEntity.ok(stokKartService.existsByStokKodu(stokKodu));
    }

    @PatchMapping("/{id}/aktif")
    public ResponseEntity<?> updateAktif(@PathVariable Long id, @RequestBody Map<String, Boolean> body) {
        boolean aktif = body.get("aktif");
        stokKartService.updateAktifDurum(id, aktif);
        return ResponseEntity.ok().build();
    }
}
