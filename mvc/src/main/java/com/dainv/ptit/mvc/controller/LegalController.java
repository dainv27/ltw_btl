package com.dainv.ptit.mvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class LegalController {
    @GetMapping("/terms")
    public String terms() {
        return "terms";
    }

    @GetMapping("/privacy")
    public String privacy() {
        return "privacy";
    }
}
