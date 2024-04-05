package com.example.demo.controller;

import com.example.demo.entities.SanPhamChiTiet;
import com.example.demo.entities.custom.ThongTinSanPhamChiTiet;
import com.example.demo.repositories.KichThuocRepository;
import com.example.demo.repositories.MauSacRepository;
import com.example.demo.repositories.SanPhamChiTietRepository;
import com.example.demo.repositories.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "keyword", required = false) Optional<String> keywordOpt,
                        @RequestParam(value = "maSpct", required = false) String maSpct) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by("id"));
        Page<ThongTinSanPhamChiTiet> p;

        if (maSpct != null && !maSpct.isEmpty()) {
            p = spctRepo.findByMaSpct(maSpct, pageable);
        } else if (keywordOpt.isPresent()) {
            String keyword = "%" + keywordOpt.get() + "%";
            p = spctRepo.findByKeyword(keyword, keyword, keyword, pageable);
        } else {
            p = spctRepo.loadAll(pageable);
        }
        model.addAttribute("pageSPCT", p);
        return "sp_chi_tiet/index";
    }


//    @GetMapping("index")
//    public String index(Model model,
//                        @RequestParam(value = "limit", defaultValue = "20") int limit,
//                        @RequestParam(value = "page", defaultValue = "0") int page,
//                        @RequestParam("keyword") Optional<String> keywordOpt) {
//        Pageable pageable = PageRequest.of(page, limit);
//        Page<ThongTinSanPhamChiTiet> p;
//        if (keywordOpt.isPresent()) {
//            String keyword = "%" + keywordOpt.get() + "%";
//            p = spctRepo.findByKeyword(keyword, keyword, keyword, pageable);
//        } else {
//            p = spctRepo.loadAll(pageable);
//        }
//        model.addAttribute("pageSPCT", p);
//        return "sp_chi_tiet/index";
//    }

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
