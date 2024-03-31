package com.example.demo.controller;

import com.example.demo.entities.KhachHang;
import com.example.demo.entities.MauSac;
import com.example.demo.repositories.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {
    @Autowired
    KhachHangRepository khRepo;

    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("listKH",khRepo.findAll());
        return "khach_hang1/index";
    }
    @GetMapping("create")
    public String create(){
        return "khach_hang1/create";
    }

    @PostMapping("store")
    public String store(KhachHang khachHang){
        this.khRepo.save(khachHang);
        return "redirect:/khach-hang/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") KhachHang kh){
        khRepo.delete(kh);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") KhachHang kh,Model model){
        model.addAttribute("kh",kh);
        return "khach_hang1/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") KhachHang oldValue, KhachHang newValue){
        newValue.setId(oldValue.getId());
        khRepo.save(newValue);
        return "redirect:/khach-hang/index";
    }



}
