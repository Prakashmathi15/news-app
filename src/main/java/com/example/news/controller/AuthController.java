package com.example.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // This should match login.html in templates folder
    }
    @GetMapping("/logout-success")
    public String logoutPage() {
        return "logout";
    }

}
