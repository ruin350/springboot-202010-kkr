package com.study.springboot202010kkr.web.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
    // 페이지연결
    @GetMapping("/account/register")
    public String loadRegister() {
        return "/account/register";
    }
}
