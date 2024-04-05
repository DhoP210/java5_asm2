package com.example.demo.controller;

import com.example.demo.entities.KichThuoc;
import com.example.demo.entities.MauSac;
import com.example.demo.entities.SanPham;
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
@RequestMapping("san-pham")
public class SanPhamController {

    @Autowired
    SanPhamRepository spRepo;

    @GetMapping("index")
    public String index(Model model,
                        @RequestParam(name = "limit", defaultValue = "6") int limit,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam("keyword") Optional<String> keywordOpt)
    {
        Pageable pageable = PageRequest.of(page, limit, Sort.by("id"));
        Page<SanPham> p ;
        if (keywordOpt.isPresent()) {
            p = spRepo.findByKeyword(keywordOpt.get(), pageable);
        } else {
            p = spRepo.findAll(pageable);
        }
        model.addAttribute("pageSP", p);
        return "san_pham/index";
    }



//    @GetMapping("index")
//    public String index(Model model){
//        model.addAttribute("listSP",spRepo.findAll());
//        return "san_pham/index";
//    }
    @GetMapping("create")
    public String create(){
        return "san_pham/create";
    }
    @PostMapping("store")
    public String store(SanPham sanPham){
        this.spRepo.save(sanPham);
        return "redirect:/san-pham/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") SanPham sp){
//        for (int i = 0; i < this.ds.size(); i++) {
//            SanPham sp = this.ds.get(i);
//            if(sp.getMa().equals(maSanPham)){
//                this.ds.remove(i);
//            }
//        }
        this.spRepo.delete(sp);
        return "redirect:/san-pham/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") SanPham sp,Model model){
        model.addAttribute("sp",sp);
        return "san_pham/edit";
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable("id") SanPham oldValue, SanPham newValue){
        newValue.setId(oldValue.getId());
        spRepo.save(newValue);
        return "redirect:/san-pham/index";
    }




}
