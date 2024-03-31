package com.example.demo.repositories;

import com.example.demo.entities.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NhanVienRepository extends JpaRepository<NhanVien,Integer> {
}
