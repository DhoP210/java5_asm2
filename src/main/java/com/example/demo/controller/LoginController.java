package com.example.demo.controller;

import com.example.demo.requests.LoginRequests;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String Login() {
        return "login";
    }

    @PostMapping("login")
    public String login(LoginRequests requests){
        System.out.println(requests.getUsername() + "-" + requests.getPassword());
        return "login";
    }

    @PostMapping("/ket-qua")
    public String hienThiKetQua(@RequestParam("uname") String username,
                                @RequestParam("psw") String password,
                                Model model){

        model.addAttribute("t1",username);
        model.addAttribute("t2",password);

        System.out.println(username + "-" + password);
        return "ket-qua";
    }
}
