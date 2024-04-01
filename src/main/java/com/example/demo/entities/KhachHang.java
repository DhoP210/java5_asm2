package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Setter@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang {
    private String ma;
    private String ten;
    private int trangThai;
    private Integer id;
    private String sdt;

    @Basic
    @Column(name = "Ma", nullable = false, length = 255)
    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    @Basic
    @Column(name = "Ten", nullable = false, length = 255)
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Basic
    @Column(name = "TrangThai", nullable = false)
    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    @Id
    @Column(name = "ID", nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SDT", nullable = false, length = 255)
    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KhachHang khachHang = (KhachHang) o;
        return trangThai == khachHang.trangThai && Objects.equals(ma, khachHang.ma) && Objects.equals(ten, khachHang.ten) && Objects.equals(id, khachHang.id) && Objects.equals(sdt, khachHang.sdt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ma, ten, sdt, trangThai);
    }
}
