package com.example.welcomeapp.controller;

import com.example.welcomeapp.model.WelcomeMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String showWelcomePage(Model model) {
        WelcomeMessage welcomeMessage = new WelcomeMessage("Chào mừng bạn đến với trang web!", LocalDateTime.now());
        model.addAttribute("message", welcomeMessage);
        return "welcome";
    }
}
