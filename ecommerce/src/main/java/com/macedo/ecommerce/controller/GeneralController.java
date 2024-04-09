package com.macedo.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.macedo.ecommerce.model.User;

@Controller
public class GeneralController {
    @RequestMapping("/")
    public String redirecionarHome(Model model) {

        model.addAttribute("user", new User());
        return "home.html";
    }
}
