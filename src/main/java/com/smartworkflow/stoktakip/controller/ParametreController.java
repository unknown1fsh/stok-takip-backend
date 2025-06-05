package com.smartworkflow.stoktakip.controller;

import com.smartworkflow.stoktakip.dto.ParametreDto;
import com.smartworkflow.stoktakip.service.ParametreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parametre")
@RequiredArgsConstructor
public class ParametreController {

    private final ParametreService parametreService;

    @PostMapping
    public ResponseEntity<ParametreDto> save(@RequestBody ParametreDto dto) {
        return ResponseEntity.ok(parametreService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParametreDto> update(@PathVariable Long id, @RequestBody ParametreDto dto) {
        return ResponseEntity.ok(parametreService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        parametreService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParametreDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(parametreService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ParametreDto>> getAll() {
        return ResponseEntity.ok(parametreService.getAll());
    }

    @GetMapping("/kodu/{parametreKodu}")
    public ResponseEntity<ParametreDto> getByKodu(@PathVariable String parametreKodu) {
        return ResponseEntity.ok(parametreService.getByKodu(parametreKodu));
    }

    @GetMapping("/exists/{parametreKodu}")
    public ResponseEntity<Boolean> existsByKodu(@PathVariable String parametreKodu) {
        return ResponseEntity.ok(parametreService.existsByKodu(parametreKodu));
    }
}