package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;

@Entity
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor

public class HoaDon {
    private Date ngayMuaHang;
    private int trangThai;
    private Integer id;
    private Integer idKh;
    private Integer idNv;

    @Basic
    @Column(name = "NgayMuaHang", nullable = false)
    public Date getNgayMuaHang() {
        return ngayMuaHang;
    }

    public void setNgayMuaHang(Date ngayMuaHang) {
        this.ngayMuaHang = ngayMuaHang;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "IdKH", nullable = false)
    public Integer getIdKh() {
        return idKh;
    }

    public void setIdKh(Integer idKh) {
        this.idKh = idKh;
    }

    @Basic
    @Column(name = "IdNV", nullable = false)
    public Integer getIdNv() {
        return idNv;
    }

    public void setIdNv(Integer idNv) {
        this.idNv = idNv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoaDon hoaDon = (HoaDon) o;
        return trangThai == hoaDon.trangThai && Objects.equals(ngayMuaHang, hoaDon.ngayMuaHang) && Objects.equals(id, hoaDon.id) && Objects.equals(idKh, hoaDon.idKh) && Objects.equals(idNv, hoaDon.idNv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idKh, idNv, ngayMuaHang, trangThai);
    }
}
