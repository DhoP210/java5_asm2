package com.example.demo.entities.custom;

import com.example.demo.entities.HoaDonChiTiet;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonCTTime {
    private Integer idHoaDon;
    private Integer soLuong;
    private Double donGia;
    private int trangThai;
    private Integer id;
    private Integer idSpct;
    private String thoiGianString;

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
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss[.fffffffff]")
    public String getThoiGianString() {
        return thoiGianString;
    }

    public void setThoiGianString(String thoiGianString) {
        this.thoiGianString = thoiGianString;
    }


}
