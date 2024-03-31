package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class SanPhamChiTiet {
    private Integer id;
    private Integer idMauSac;
    private Integer idKichThuoc;
    private Integer idSanPham;
    private String maSpct;
    private Integer soLuong;
    private Double donGia;
    private Integer trangThai;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "IdMauSac", nullable = false)
    public Integer getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(Integer idMauSac) {
        this.idMauSac = idMauSac;
    }

    @Basic
    @Column(name = "IdKichThuoc", nullable = false)
    public Integer getIdKichThuoc() {
        return idKichThuoc;
    }

    public void setIdKichThuoc(Integer idKichThuoc) {
        this.idKichThuoc = idKichThuoc;
    }

    @Basic
    @Column(name = "IdSanPham", nullable = false)
    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

    @Basic
    @Column(name = "MaSPCT", nullable = false, length = 255)
    public String getMaSpct() {
        return maSpct;
    }

    public void setMaSpct(String maSpct) {
        this.maSpct = maSpct;
    }

    @Basic
    @Column(name = "SoLuong", nullable = false)
    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    @Basic
    @Column(name = "DonGia", nullable = false, precision = 0)
    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    @Basic
    @Column(name = "TrangThai", nullable = false)
    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SanPhamChiTiet that = (SanPhamChiTiet) o;
        return Objects.equals(id, that.id) && Objects.equals(idMauSac, that.idMauSac) && Objects.equals(idKichThuoc, that.idKichThuoc) && Objects.equals(idSanPham, that.idSanPham) && Objects.equals(maSpct, that.maSpct) && Objects.equals(soLuong, that.soLuong) && Objects.equals(donGia, that.donGia) && Objects.equals(trangThai, that.trangThai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idMauSac, idKichThuoc, idSanPham, maSpct, soLuong, donGia, trangThai);
    }
}
