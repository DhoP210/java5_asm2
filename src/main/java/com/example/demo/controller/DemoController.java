package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DemoController {
    @RequestMapping("a")
    public String helloa()
    {
        return "a";
    }
    @RequestMapping("")
    public String hello()
    {
        return "a";
    }
}
