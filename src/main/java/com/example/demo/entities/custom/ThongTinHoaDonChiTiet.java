package com.example.demo.entities.custom;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThongTinHoaDonChiTiet {
    @Id
    private Integer id;
    private Date ngayMuaHang;
    private String maSpct;
    private Integer soLuong;
    private Double donGia;
    private int trangThai;
    private Timestamp thoiGian;
}
