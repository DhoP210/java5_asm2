package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
public class KichThuoc {
    private String ma; // tìm kiếm
    private String ten; // tìm kiếm
    private int trangThai; // lọc
    private Integer id;

    @Basic
    @Column(name = "Ma", nullable = true, length = 255)
    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    @Basic
    @Column(name = "Ten", nullable = true, length = 255)
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
        KichThuoc kichThuoc = (KichThuoc) o;
        return trangThai == kichThuoc.trangThai && Objects.equals(ma, kichThuoc.ma) && Objects.equals(ten, kichThuoc.ten) && Objects.equals(id, kichThuoc.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ma, ten, trangThai);
    }
}
