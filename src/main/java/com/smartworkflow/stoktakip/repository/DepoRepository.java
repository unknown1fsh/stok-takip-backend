package com.smartworkflow.stoktakip.repository;

import com.smartworkflow.stoktakip.entity.Depo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepoRepository extends JpaRepository<Depo, Long> {

    Optional<Depo> findByDepoKodu(String depoKodu);

    boolean existsByDepoKodu(String depoKodu);
}
