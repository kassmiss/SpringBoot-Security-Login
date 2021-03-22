package com.grlife.login.controller;

import com.grlife.login.domain.UserInfo;
import com.grlife.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final LoginService loginService;

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping("/signup")
    public String signup(Model model) {
        return "signup";
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo) {
        System.out.println("컨트롤러");
        loginService.save(userInfo);
        return "redirect:/login";
    }

}
