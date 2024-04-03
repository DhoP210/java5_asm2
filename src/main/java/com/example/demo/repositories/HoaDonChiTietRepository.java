package com.example.demo.repositories;

import com.example.demo.entities.HoaDonChiTiet;
import com.example.demo.entities.custom.ThongTinHoaDonChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet,Integer> {
    @Query("SELECT new ThongTinHoaDonChiTiet(hc.id, hd.ngayMuaHang, sc.maSpct, hc.soLuong, hc.donGia, hc.trangThai, hc.thoiGian) " +
            "FROM HoaDonChiTiet hc " +
            "INNER JOIN HoaDon hd ON hc.idHoaDon = hd.id " +
            "INNER JOIN SanPhamChiTiet sc ON hc.idSpct = sc.id")
    public Page<ThongTinHoaDonChiTiet> loadAll(Pageable pageable);


    @Query ("select new ThongTinHoaDonChiTiet (hc.id, hd.ngayMuaHang, sc.maSpct, hc.soLuong, hc.donGia, hc.trangThai, hc.thoiGian) from HoaDonChiTiet hc " +
            "inner join HoaDon hd on hc.idHoaDon = hd.id " +
            "inner join SanPhamChiTiet sc on hc.idSpct = sc.id " +
            "where sc.maSpct like %:keyword% ")
    public Page<ThongTinHoaDonChiTiet> findByKeyword(@Param("keyword") String maSpct, Pageable pageable);

    @Query("SELECT new ThongTinHoaDonChiTiet(hc.id, hd.ngayMuaHang, sc.maSpct, hc.soLuong, hc.donGia, hc.trangThai, hc.thoiGian) " +
            "FROM HoaDonChiTiet hc " +
            "INNER JOIN HoaDon hd ON hc.idHoaDon = hd.id " +
            "INNER JOIN SanPhamChiTiet sc ON hc.idSpct = sc.id " +
            "WHERE hd.ngayMuaHang = :ngayMuaHang")
    public Page<ThongTinHoaDonChiTiet> findByNgayMuaHang(@Param("ngayMuaHang") Date ngayMuaHang, Pageable pageable);
}
