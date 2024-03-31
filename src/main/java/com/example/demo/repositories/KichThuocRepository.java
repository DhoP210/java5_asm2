package com.example.demo.repositories;

import com.example.demo.entities.KichThuoc;
import com.example.demo.entities.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KichThuocRepository extends JpaRepository<KichThuoc, Integer> {
//    public KichThuoc findByMa(String ma);
}
