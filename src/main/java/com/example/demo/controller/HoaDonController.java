package com.example.demo.controller;

import com.example.demo.entities.HoaDon;
import com.example.demo.repositories.HoaDonRepository;
import com.example.demo.repositories.KhachHangRepository;
import com.example.demo.repositories.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("hoa-don")
public class HoaDonController {

    @Autowired
    HoaDonRepository hdRepo;

    @Autowired
    NhanVienRepository nvRepo;
    @Autowired
    KhachHangRepository khRepo;


    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("listHD",hdRepo.findAll());
        return "hoa_don/index";
    }
    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("listNV",nvRepo.findAll());
        model.addAttribute("listKH",khRepo.findAll());
        return "hoa_don/create";
    }
    @PostMapping("store")
    public String store(HoaDon hoaDon){
        this.hdRepo.save(hoaDon);
        return "redirect:/hoa-don/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") HoaDon hd){
        hdRepo.delete(hd);
        return "redirect:/hoa-don/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") HoaDon hd, Model model){
        model.addAttribute("listNV",nvRepo.findAll());
        model.addAttribute("listKH",khRepo.findAll());
        model.addAttribute("hd",hd);
        return "hoa_don/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") HoaDon oldValue,HoaDon newValue){
        newValue.setId(oldValue.getId());
        hdRepo.save(newValue);
        return "redirect:/hoa-don/index";
    }



}
