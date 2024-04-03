package com.example.demo.controller;

import com.example.demo.entities.HoaDon;
import com.example.demo.entities.custom.ThongTinHoaDon;
import com.example.demo.repositories.HoaDonRepository;
import com.example.demo.repositories.KhachHangRepository;
import com.example.demo.repositories.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
    public String index(Model model,
                        @RequestParam(value = "limit", defaultValue = "8") int limit,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam("keyword") Optional<String> keywordOpt) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<ThongTinHoaDon> p;
        if (keywordOpt.isPresent()) {
            String s = "%" + keywordOpt.get() + "%";
            p = hdRepo.findByKeyword(s, s, pageable);
        } else {
            p = hdRepo.loadAll(pageable);
        }
        model.addAttribute("pageHD", p);
        return "hoa_don/index";
    }


//    @GetMapping("index")
//    public String index(Model model,
//                        @RequestParam(value = "limit",defaultValue = "8") int limit,
//                        @RequestParam(value = "page",defaultValue = "0") int page){
//        Pageable pageable = PageRequest.of(page,limit);
//        Page<HoaDon> p = hdRepo.findAll(pageable);
//        model.addAttribute("pageHD",p);
//        return "hoa_don/index";
//    }
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
