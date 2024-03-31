package com.example.demo.controller;

import com.example.demo.entities.MauSac;
import com.example.demo.entities.SanPham;
import com.example.demo.repositories.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("san-pham")
public class SanPhamController {
//    private List<SanPham> ds = new ArrayList<>();
//    public SanPhamController(){
//        this.ds.add(new SanPham("SP1","sản phẩm 1",1));
//        this.ds.add(new SanPham("SP2","sản phẩm 2",0));
//    }
    @Autowired
    SanPhamRepository spRepo;
    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("listSP",spRepo.findAll());
        return "san_pham/index";
    }
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
