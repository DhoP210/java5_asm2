package com.example.demo.controller;

import com.example.demo.entities.KichThuoc;
import com.example.demo.entities.MauSac;
import com.example.demo.entities.NhanVien;
import com.example.demo.repositories.NhanVienRepository;
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
@RequestMapping("nhan-vien")
public class NhanVienController {

    @Autowired
    NhanVienRepository nvRepo;

    @GetMapping("index")
    public String index(Model model,
                        @RequestParam(value = "limit", defaultValue = "8") int limit,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam("keyword") Optional<String> keywordOpt
                        ){
        Pageable pageable = PageRequest.of(page,limit, Sort.by("id"));
        Page<NhanVien> p ;
        if (keywordOpt.isPresent()) {
            p = nvRepo.findByKeyword(keywordOpt.get(), pageable);
        } else {
            p = nvRepo.findAll(pageable);
        }
        model.addAttribute("pageNV",p);
        return "nhan_vien/index";
    }


//    @GetMapping("index")
//    public String index(Model model){
//        model.addAttribute("listNV", nvRepo.findAll());
//        return "nhan_vien/index";
//    }
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
