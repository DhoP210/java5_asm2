package com.example.demo.repositories;

import com.example.demo.entities.MauSac;
import com.example.demo.entities.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SanPhamRepository extends JpaRepository<SanPham,Integer> {
    @Query("SELECT ms FROM SanPham ms WHERE ms.ten LIKE %:keyword%")
    public Page<SanPham> findByKeyword(@Param("keyword") String ten, Pageable pageable);
}
