package com.dainv.ptit.mvc.controller;

import com.dainv.ptit.mvc.model.UserLoginInfo;
import com.dainv.ptit.mvc.model.UserRegisterInfo;
import com.dainv.ptit.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserRegisterInfo());
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute UserRegisterInfo user) {
        userService.register(user);
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
}

