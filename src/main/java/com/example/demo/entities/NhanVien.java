package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {
// kt.getTen().contains(tenNV) & kt.getTenDangNhap().contains(tenDangNhap) & kt.getMatKhau().contains(matKhau) & kt.getMa().contains(maNV)
    private String ma;
    private String ten;
    private String tenDangNhap;
    private String matKhau;
    private int trangThai;
    private Integer id;

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
    @Column(name = "TenDangNhap", nullable = false, length = 255)
    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    @Basic
    @Column(name = "MatKhau", nullable = false, length = 255)
    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Basic
    @Column(name = "TrangThai", nullable = true)
    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NhanVien nhanVien = (NhanVien) o;
        return trangThai == nhanVien.trangThai && Objects.equals(ma, nhanVien.ma) && Objects.equals(ten, nhanVien.ten) && Objects.equals(tenDangNhap, nhanVien.tenDangNhap) && Objects.equals(matKhau, nhanVien.matKhau) && Objects.equals(id, nhanVien.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ten, ma, tenDangNhap, matKhau, trangThai);
    }
}
