package com.example.demo.repositories;

import com.example.demo.entities.KichThuoc;
import com.example.demo.entities.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KichThuocRepository extends JpaRepository<KichThuoc, Integer> {
//    public KichThuoc findByMa(String ma);
@Query("SELECT ms FROM KichThuoc ms WHERE ms.ten LIKE %:keyword%")
public Page<KichThuoc> findByKeyword(@Param("keyword") String ten, Pageable pageable);
}
