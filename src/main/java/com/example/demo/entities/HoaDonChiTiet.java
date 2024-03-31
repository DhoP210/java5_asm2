package com.example.demo.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonChiTiet {
    private Integer idHoaDon;
    private Integer soLuong;
    private Double donGia;
    private int trangThai;
    private Integer id;
    private Integer idSpct;
    private Timestamp thoiGian;

    @Basic
    @Column(name = "IdHoaDon", nullable = false)
    public Integer getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(Integer idHoaDon) {
        this.idHoaDon = idHoaDon;
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

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "IdSPCT", nullable = false)
    public Integer getIdSpct() {
        return idSpct;
    }

    public void setIdSpct(Integer idSpct) {
        this.idSpct = idSpct;
    }

    @Basic
    @Column(name = "ThoiGian", nullable = false)
    public Timestamp getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Timestamp thoiGian) {
        this.thoiGian = thoiGian;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoaDonChiTiet that = (HoaDonChiTiet) o;
        return trangThai == that.trangThai && Objects.equals(idHoaDon, that.idHoaDon) && Objects.equals(soLuong, that.soLuong) && Objects.equals(donGia, that.donGia) && Objects.equals(id, that.id) && Objects.equals(idSpct, that.idSpct) && Objects.equals(thoiGian, that.thoiGian);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idHoaDon, idSpct, soLuong, donGia, thoiGian, trangThai);
    }
}
