package com.example.demo.controller;

import com.example.demo.entities.HoaDonChiTiet;
import com.example.demo.entities.KichThuoc;
import com.example.demo.entities.MauSac;
import com.example.demo.entities.custom.HoaDonCTTime;
import com.example.demo.repositories.HoaDonChiTietRepository;
import com.example.demo.repositories.HoaDonRepository;
import com.example.demo.repositories.SanPhamChiTietRepository;
import jakarta.persistence.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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
    public String index(Model model,
                        @RequestParam(value = "limit",defaultValue = "12") int limit,
                        @RequestParam(value = "page",defaultValue = "0") int page
                        ){
        Pageable pageable = PageRequest.of(page,limit);
        Page<HoaDonChiTiet> p = hdctRepo.findAll(pageable);
        model.addAttribute("pageHC",p);
        return "hoa_don_ct/index";
    }
    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("hd",hdRepo.findAll());
        model.addAttribute("sp",spctRepo.findAll());
        return "hoa_don_ct/create";
    }
    @PostMapping("store")
    public String store(HoaDonChiTiet ct
//                        ,@RequestParam("thoiGian") String thoiGian
    ){
//        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.parse(thoiGian.replace("T", " ")));
//        ct.setThoiGian(timestamp);
        hdctRepo.save(ct);
        return "redirect:/hoa-don-ct/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") HoaDonChiTiet hdct ){
        hdctRepo.delete(hdct);
        return "redirect:/hoa-don-ct/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") HoaDonChiTiet hdct,HoaDonCTTime hcTime, Model model){
        model.addAttribute("hd",hdRepo.findAll());
        model.addAttribute("sp",spctRepo.findAll());
        model.addAttribute("hc",hdct);
        model.addAttribute("hcTime",hcTime);

        return "hoa_don_ct/edit";
    }


    @PostMapping("update/{id}")
    public String update(@PathVariable("id") HoaDonChiTiet oldValue, HoaDonChiTiet newValue, HoaDonCTTime hcTime){
        newValue.setId(oldValue.getId());
//        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]");
        DateTimeFormatter dateFormat = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime dateTime = LocalDateTime.parse( hcTime.getThoiGianString(), dateFormat);
        Timestamp ts = Timestamp.valueOf(dateTime);
        newValue.setThoiGian(ts);
        hdctRepo.save(newValue);
        return "redirect:/hoa-don-ct/index";
    }



}
