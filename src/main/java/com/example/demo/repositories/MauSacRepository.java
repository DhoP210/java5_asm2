package com.example.demo.repositories;

import com.example.demo.entities.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MauSacRepository extends JpaRepository<MauSac, Integer> {
    // C1: Viết Query tìm theo Ma.
//    @Query("SELECT ms FROM MauSac ms WHERE ms.ma = :ma")
//    public MauSac findByMa(@Param("ma") String ma);

//    @Query("SELECT ms FROM MauSac ms WHERE ms.ma = ?1")
//    public MauSac findByMa(String ma);

    public MauSac findByMa(String ma);
}
