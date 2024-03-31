package com.example.demo.controller;

import com.example.demo.entities.KichThuoc;
import com.example.demo.repositories.KichThuocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("kich-thuoc")
public class KichThuocController {

//    private List<KichThuoc> ds = new ArrayList<>();
//    public KichThuocController(){
//        this.ds.add(new KichThuoc("KT1","kích thước nhỏ",0));
//        this.ds.add(new KichThuoc("KT2","kích thước to",1));
//        this.ds.add(new KichThuoc("PH1","kích thước Vừa",1));
//    }

    @Autowired
    KichThuocRepository ktRepo;


    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("listKT",ktRepo.findAll());
        return "kich_thuoc/index";
    }
    @GetMapping("create")
    public String create(){
        return "kich_thuoc/create";
    }

    @PostMapping("store")
    public String store(KichThuoc kt){
        this.ktRepo.save(kt);
        return "redirect:/kich-thuoc/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") KichThuoc kt ){
//        for (int i = 0; i < this.ds.size(); i++) {
//            KichThuoc kt = this.ds.get(i);
//            if (kt.getMa().equals(maKichThuoc)){
//                this.ds.remove(i);
//            }
//        }
        this.ktRepo.delete(kt);
        return "redirect:/kich-thuoc/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") KichThuoc kt, Model model){
//        for ( KichThuoc kt : this.ds){
//            if (kt.getMa().equals(maKichThuoc)){
//                model.addAttribute("kt",kt);
//            }
//        }
        model.addAttribute("kt", kt);
        return "kich_thuoc/edit";
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable("id") KichThuoc oldValue,KichThuoc newValue){
//        for (int i = 0; i < this.ds.size(); i++) {
//            KichThuoc kt = this.ds.get(i);
//            if (kt.getMa().equals(maKichThuoc)){
//                this.ds.set(i,newValue);
//
//            }
//        }
        newValue.setId(oldValue.getId());
        this.ktRepo.save(newValue);
        return "redirect:/kich-thuoc/index";
    }

//    @GetMapping("search")
//    public String timKiem(Model model){
//            // tạo ra 1 list con cục bộ ở trong này
//            // duyệt tìm kiếm có chứa phần tử ở tên và mã / sau đó truyền vào list con đó và hiển thị ra nó
//        List<KichThuoc> listCon = new ArrayList<>();
//        for (KichThuoc tk : ds){
//            if(ds.indexOf(tk))
//        }
//        return "kich_thuoc/index";
//    }
//    ------------
//    @GetMapping("/search-ma")
//    public String timTheoMa(@RequestParam("ma") String maKT, Model model){
//        List<KichThuoc> listMa = new ArrayList<>();
//        for(KichThuoc kt : ds){
//            if(kt.getMa().contains(maKT)){
//                listMa.add(kt);
//            };
//            model.addAttribute("listKT",listMa);
//        }
//        return "kich_thuoc/index";
//    }
//    @GetMapping("/search-ten")
//    public String timTheoTen(@RequestParam("ten") String tenKT, Model model){
//        List<KichThuoc> listTen = new ArrayList<>();
//        for(KichThuoc kt : ds){
//            if(kt.getTen().contains(tenKT)){
//                listTen.add(kt);
//            }
//            model.addAttribute("listKT",listTen);
//        }
//        return "kich_thuoc/index";
//    }
//    ----------------
//    @GetMapping("/search")
//    public String timKiem(@RequestParam("ma") String maKT ,
//                            @RequestParam("ten") String tenKT,
////                            @RequestParam ("trangThai") Integer trangThaiKT,
//                            Model model){
//
//        List<KichThuoc> listTen = new ArrayList<>();
//        List<KichThuoc> listMa = new ArrayList<>();
//        List<KichThuoc> listCon = new ArrayList<>();
////        List<KichThuoc> listTT = new ArrayList<>();
//
//        if (maKT == ""){
//            for(KichThuoc kt : ds){
//                if(kt.getTen().contains(tenKT)){
//                    listTen.add(kt);
//                }
//            }
//            model.addAttribute("listKT",listTen);
//            return "kich_thuoc/index";
//        }
//        if(tenKT == ""){
//            for(KichThuoc kt : ds){
//                if(kt.getMa().contains(maKT)){
//                    listMa.add(kt);
//                }
//            }
//            model.addAttribute("listKT",listMa);
//            return "kich_thuoc/index";
//        }
//        if (trangThaiKT == null){
//            for(KichThuoc kt : ds){
//                if(kt.getMa().contains(maKT) & kt.getTen().contains(tenKT) & kt.getTrangThai() == (0&1)){
//                    listCon.add(kt);
//                }
//            }
//            model.addAttribute("listKT",listCon);
//            return "kich_thuoc/index";
//        }
//        if (maKT == "" & trangThaiKT == null){
//            for(KichThuoc kt : ds){
//                if(kt.getTen().contains(tenKT) & kt.getTrangThai() == (0&1)){
//                    listTen.add(kt);
//                }
//            }
//            model.addAttribute("listKT",listTen);
//            return "kich_thuoc/index";
//        }
//        if (tenKT == "" & trangThaiKT == null){
//            for(KichThuoc kt : ds){
//                if(kt.getMa().contains(maKT)& kt.getTrangThai() == (0&1)){
//                    listMa.add(kt);
//                }
//            }
//            model.addAttribute("listKT",listMa);
//            return "kich_thuoc/index";
//        }
//        if (maKT == "" & tenKT == ""){
//            for(KichThuoc kt : ds){
//                if(kt.getTrangThai() == trangThaiKT){
//                    listTT.add(kt);
//                }
//            }
//            model.addAttribute("listKT",listTT);
//            return "kich_thuoc/index";
//        }
//        for(KichThuoc kt : ds){
//            if(kt.getMa().contains(maKT) & kt.getTen().contains(tenKT)){
//                listCon.add(kt);
//            }
//            model.addAttribute("listKT",listCon);
//        }
//        return "kich_thuoc/index";
//    }
//    @GetMapping("/loc")
//    public String loc(@RequestParam ("trangThai") int trangThaiKT,Model model){
//        List<KichThuoc> listTT = new ArrayList<>();
//        for(KichThuoc kt : ds){
//                if(kt.getTrangThai() == trangThaiKT){
//                    listTT.add(kt);
//                }
//            }
//            model.addAttribute("listKT",listTT);
//            return "kich_thuoc/index";
//    }

}
