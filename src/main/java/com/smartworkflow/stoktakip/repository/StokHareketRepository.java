package com.smartworkflow.stoktakip.repository;

import com.smartworkflow.stoktakip.entity.StokHareket;
import com.smartworkflow.stoktakip.enums.HareketTipi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StokHareketRepository extends JpaRepository<StokHareket, Long> {

    List<StokHareket> findByHareketTipi(HareketTipi hareketTipi);

    List<StokHareket> findByDepo_Id(Long depoId);

    List<StokHareket> findByStokKart_Id(Long stokKartId);

    @Query("SELECT COUNT(sh) FROM StokHareket sh WHERE sh.depo.id = :depoId")
    Long countByDepoId(@Param("depoId") Long depoId);

    boolean existsByStokKart_Id(Long stokKartId);
}
