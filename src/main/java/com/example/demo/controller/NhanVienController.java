package com.example.demo.controller;

import com.example.demo.entities.KichThuoc;
import com.example.demo.entities.MauSac;
import com.example.demo.entities.NhanVien;
import com.example.demo.repositories.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienController {

    @Autowired
    NhanVienRepository nvRepo;

    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("listNV", nvRepo.findAll());
        return "nhan_vien/index";
    }
    @GetMapping("create")
    public String create(){
        return "nhan_vien/create";
    }
    @PostMapping("store")
    public String store(NhanVien nv){
        this.nvRepo.save(nv);
        return "redirect:/nhan-vien/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") NhanVien nv ){
        nvRepo.delete(nv);
        return "redirect:/nhan-vien/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") NhanVien nv, Model model){
        model.addAttribute("nv",nv);
        return "nhan_vien/edit";
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable("id") NhanVien oldValue,NhanVien newValue){
        newValue.setId(oldValue.getId());
        nvRepo.save(newValue);
        return "redirect:/nhan-vien/index";
    }


}
