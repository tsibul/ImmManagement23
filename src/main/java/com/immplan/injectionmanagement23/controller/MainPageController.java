package com.immplan.injectionmanagement23.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainPageController {
        @GetMapping("/")
        @ResponseBody
        public String myPage() {
            return "index";
        }
}
