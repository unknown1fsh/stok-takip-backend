package com.smartworkflow.stoktakip.repository;

import com.smartworkflow.stoktakip.entity.Parametre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParametreRepository extends JpaRepository<Parametre, Long> {

    Optional<Parametre> findByParametreKodu(String parametreKodu);

    boolean existsByParametreKodu(String parametreKodu);
}
