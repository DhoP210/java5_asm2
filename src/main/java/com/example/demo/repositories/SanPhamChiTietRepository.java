package com.example.demo.repositories;

import com.example.demo.entities.SanPhamChiTiet;
import com.example.demo.entities.custom.ThongTinSanPhamChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface SanPhamChiTietRepository extends JpaRepository<SanPhamChiTiet,Integer> {
    @Query("SELECT DISTINCT new ThongTinSanPhamChiTiet " +
            "(sc.id, ms.ten, kt.ten, sp.ten, sc.maSpct, sc.soLuong, sc.donGia, sc.trangThai) " +
            "FROM SanPhamChiTiet sc " +
            "INNER JOIN MauSac ms ON sc.idMauSac = ms.id " +
            "INNER JOIN KichThuoc kt ON sc.idKichThuoc = kt.id " +
            "INNER JOIN SanPham sp ON sc.idSanPham = sp.id ")
    public Page<ThongTinSanPhamChiTiet> loadAll(Pageable pageable);

    @Query("select new ThongTinSanPhamChiTiet " +
            "(sc.id, ms.ten, kt.ten, sp.ten, sc.maSpct, sc.soLuong, sc.donGia, sc.trangThai) " +
            "from SanPhamChiTiet sc " +
            "inner join MauSac ms on sc.idMauSac = ms.id " +
            "inner join KichThuoc kt on sc.idKichThuoc = kt.id " +
            "inner join SanPham sp on sc.idSanPham = sp.id " +
            "where ms.ten like :keyword1 or kt.ten like :keyword2 or sp.ten like :keyword3")
    public Page<ThongTinSanPhamChiTiet> findByKeyword(@Param("keyword1") String tenMS, @Param("keyword2") String tenKT, @Param("keyword3")String tenSP, Pageable pageable);

    @Query("SELECT new ThongTinSanPhamChiTiet " +
            "(sc.id, ms.ten, kt.ten, sp.ten, sc.maSpct, sc.soLuong, sc.donGia, sc.trangThai) " +
            "FROM SanPhamChiTiet sc " +
            "INNER JOIN MauSac ms ON sc.idMauSac = ms.id " +
            "INNER JOIN KichThuoc kt ON sc.idKichThuoc = kt.id " +
            "INNER JOIN SanPham sp ON sc.idSanPham = sp.id " +
            "WHERE sc.maSpct LIKE :keyword")
    public Page<ThongTinSanPhamChiTiet> findByMaSpct(@Param("keyword") String maSpct, Pageable pageable);

}
