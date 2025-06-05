package com.smartworkflow.stoktakip.repository;

import com.smartworkflow.stoktakip.entity.StokKart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StokKartRepository extends JpaRepository<StokKart, Long> {

    Optional<StokKart> findByStokKodu(String stokKodu);

    boolean existsByStokKodu(String stokKodu);

    List<StokKart> findByAktif(boolean aktif);
}
