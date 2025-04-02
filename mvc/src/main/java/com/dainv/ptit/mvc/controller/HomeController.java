package com.dainv.ptit.mvc.controller;

import com.dainv.ptit.mvc.model.Me;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(Model model){
        // Tạo ra thông tin
        List<Me> profile = new ArrayList<>();
        profile.add(new Me("fullname", "Nguyễn Hoàng Nam"));
        profile.add(new Me("nickname", "lốddaf"));
        profile.add(new Me("gmail", "loda.namnh@gmail.com"));
        profile.add(new Me("facebook", "https://www.facebook.com/nam.tehee"));
        profile.add(new Me("website", "https://loda.me"));

        // Đưa thông tin vào Model
        model.addAttribute("lodaProfile", profile);

        // TRả về template profile.html
        return "index";
    }
}
