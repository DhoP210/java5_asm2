package com.example.demo.entities.custom;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThongTinSanPhamChiTiet {
    @Id
    private Integer id;
    private String tenMS;
    private String tenKT;
    private String tenSP;
    private String maSpct;
    private Integer soLuong;
    private Double donGia;
    private Integer trangThai;
}
