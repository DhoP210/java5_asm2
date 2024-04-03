package com.example.demo.entities.custom;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThongTinHoaDon {
    @Id
    private Integer id;
    private String tenKH;
    private String tenNV;
    private Date ngayMua;
    private int trangThai;
}
