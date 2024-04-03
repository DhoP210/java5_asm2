package com.example.demo.repositories;

import com.example.demo.entities.KhachHang;
import com.example.demo.entities.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KhachHangRepository extends JpaRepository<KhachHang,Integer> {
    @Query("SELECT ms FROM KhachHang ms WHERE ms.ten LIKE %:keyword%")
    public Page<KhachHang> findByKeyword(@Param("keyword") String ten, Pageable pageable);
}
