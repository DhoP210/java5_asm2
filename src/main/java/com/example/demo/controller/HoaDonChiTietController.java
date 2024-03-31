package com.example.demo.controller;

import com.example.demo.entities.HoaDonChiTiet;
import com.example.demo.entities.KichThuoc;
import com.example.demo.entities.MauSac;
import com.example.demo.repositories.HoaDonChiTietRepository;
import com.example.demo.repositories.HoaDonRepository;
import com.example.demo.repositories.SanPhamChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("hoa-don-ct")
public class HoaDonChiTietController {
    @Autowired
    HoaDonChiTietRepository hdctRepo;
    @Autowired
    HoaDonRepository hdRepo;
    @Autowired
    SanPhamChiTietRepository spctRepo;



    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("listHC",hdctRepo.findAll());
        return "hoa_don_ct/index";
    }
    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("hd",hdRepo.findAll());
        model.addAttribute("sp",spctRepo.findAll());
        return "hoa_don_ct/create";
    }
    @PostMapping("store")
    public String store(HoaDonChiTiet ct){
        hdctRepo.save(ct);
        return "redirect:/hoa-don-ct/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") HoaDonChiTiet hdct ){
        hdctRepo.delete(hdct);
        return "redirect:/hoa-don-ct/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") HoaDonChiTiet hdct, Model model){
        model.addAttribute("hd",hdRepo.findAll());
        model.addAttribute("sp",spctRepo.findAll());
        model.addAttribute("hc",hdct);

        return "hoa_don_ct/edit";
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable("id") HoaDonChiTiet oldValue,HoaDonChiTiet newValue){
        newValue.setId(oldValue.getId());
        hdctRepo.save(newValue);
        return "redirect:/hoa-don-ct/index";
    }



}
