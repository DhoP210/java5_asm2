package com.example.demo.repositories;

import com.example.demo.entities.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SanPhamRepository extends JpaRepository<SanPham,Integer> {

}
