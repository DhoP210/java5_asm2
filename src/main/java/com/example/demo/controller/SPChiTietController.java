package com.example.demo.controller;

import com.example.demo.entities.SanPhamChiTiet;
import com.example.demo.repositories.KichThuocRepository;
import com.example.demo.repositories.MauSacRepository;
import com.example.demo.repositories.SanPhamChiTietRepository;
import com.example.demo.repositories.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("sp-chi-tiet")
public class SPChiTietController {
    @Autowired
    SanPhamChiTietRepository spctRepo;
    @Autowired
    MauSacRepository msRepo;
    @Autowired
    SanPhamRepository spRepo;
    @Autowired
    KichThuocRepository ktRepo;


    @GetMapping("index")
    public String index(Model model,
                        @RequestParam(value = "limit", defaultValue = "20") int limit,
                        @RequestParam(value = "page", defaultValue = "0") int page
                        ){
        Pageable pageable = PageRequest.of(page,limit);
        Page<SanPhamChiTiet> p = spctRepo.findAll(pageable);
        model.addAttribute("pageSPCT",p);
        return "sp_chi_tiet/index";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("listMS", msRepo.findAll());
        model.addAttribute("listKT", ktRepo.findAll());
        model.addAttribute("listSP", spRepo.findAll());
        return "sp_chi_tiet/create";
    }
    @PostMapping("store")
    public String store(SanPhamChiTiet spChiTiet){
        this.spctRepo.save(spChiTiet);
        return "redirect:/sp-chi-tiet/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") SanPhamChiTiet sanPhamChiTiet ){
        spctRepo.delete(sanPhamChiTiet);
        return "redirect:/sp-chi-tiet/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") SanPhamChiTiet sanPhamChiTiet, Model model){
        model.addAttribute("spct",sanPhamChiTiet);
        model.addAttribute("listMS", msRepo.findAll());
        model.addAttribute("listKT", ktRepo.findAll());
        model.addAttribute("listSP", spRepo.findAll());
        return "sp_chi_tiet/edit";
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable("id") SanPhamChiTiet oldValue,SanPhamChiTiet newValue){
            newValue.setId(oldValue.getId());
            spctRepo.save(newValue);
        return "redirect:/sp-chi-tiet/index";
    }



}
