package com.smartworkflow.stoktakip.controller;

import com.smartworkflow.stoktakip.dto.DepoDto;
import com.smartworkflow.stoktakip.service.DepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/depo")
@RequiredArgsConstructor
public class DepoController {

    private final DepoService depoService;

    @PostMapping
    public ResponseEntity<DepoDto> save(@RequestBody DepoDto dto) {
        return ResponseEntity.ok(depoService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepoDto> update(@PathVariable Long id, @RequestBody DepoDto dto) {
        return ResponseEntity.ok(depoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        depoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepoDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(depoService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<DepoDto>> getAll() {
        return ResponseEntity.ok(depoService.getAll());
    }

    @GetMapping("/exists/{depoKodu}")
    public ResponseEntity<Boolean> existsByDepoKodu(@PathVariable String depoKodu) {
        return ResponseEntity.ok(depoService.existsByDepoKodu(depoKodu));
    }
}
