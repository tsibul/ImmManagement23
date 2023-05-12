package com.immplan.injectionmanagement23.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {
    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/techcard")
    public String techCard() {
        return "techcard";
    }


    @GetMapping("/products")
    public String productsPage() {
        return "products";
    }

    @GetMapping("/equipment")
    public String equipmentPage() {
        return "equipment";
    }

    @GetMapping("/colors")
    public String colorsPage() {
        return "colors";
    }

}
