package com.example.demo.repositories;

import com.example.demo.entities.MauSac;
import com.example.demo.entities.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NhanVienRepository extends JpaRepository<NhanVien,Integer> {
    @Query("SELECT ms FROM NhanVien ms WHERE ms.ten LIKE %:keyword%")
    public Page<NhanVien> findByKeyword(@Param("keyword") String ten, Pageable pageable);
}
