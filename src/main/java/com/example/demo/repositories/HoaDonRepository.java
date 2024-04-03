package com.example.demo.repositories;

import com.example.demo.entities.HoaDon;
import com.example.demo.entities.custom.ThongTinHoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HoaDonRepository extends JpaRepository<HoaDon,Integer> {
    @Query("SELECT new ThongTinHoaDon(hd.id, kh.ten, nv.ten, hd.ngayMuaHang, hd.trangThai) FROM HoaDon hd " +
            "INNER JOIN NhanVien nv ON hd.idNv = nv.id " +
            "INNER JOIN KhachHang kh ON hd.idKh = kh.id ")
    public Page<ThongTinHoaDon> loadAll(Pageable pageable);

    @Query("SELECT new ThongTinHoaDon(hd.id, kh.ten, nv.ten, hd.ngayMuaHang, hd.trangThai) FROM HoaDon hd " +
            "INNER JOIN NhanVien nv ON hd.idNv = nv.id " +
            "INNER JOIN KhachHang kh ON hd.idKh = kh.id " +
            "WHERE kh.ten LIKE :keyword1 OR nv.ten LIKE :keyword2")
    public Page<ThongTinHoaDon> findByKeyword(@Param("keyword1") String tenKH, @Param("keyword2") String tenNV, Pageable pageable);
}
