package com.project.project1.controller;

import com.project.project1.config.CustomUserLogin;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/home")
    @ResponseBody
    public String mainPage() {
        return "hi";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/userInfo")
    @ResponseBody
    public String userInfo(Model model, @AuthenticationPrincipal CustomUserLogin customUser) {
        if (customUser != null) {
            model.addAttribute("username", customUser.getUsername());
        }
        return customUser.getUsername();
    }

    @GetMapping("/check")
    @ResponseBody
    public String check(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "세션이 이미 죽었습니다.";
        }
        return "세션 ID: " + session.getId() + ", 남은 시간: " + session.getMaxInactiveInterval() + "초";
    }

}
