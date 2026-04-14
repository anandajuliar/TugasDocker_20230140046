package com.tugas.deploy.controller;

import com.tugas.deploy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

        import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final String USERNAME = "admin";
    private final String PASSWORD = "20230140046";

    private List<User> dataUser = new ArrayList<>();

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Username atau password salah");
            return "login";
        }
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("data", dataUser);
        return "home";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute User user) {
        dataUser.add(user); // simpan ke memory
        return "redirect:/home";
    }
}
