package com.example.demo.controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @GetMapping("/all")
    public String  findAll(Model model) {
        model.addAttribute("users",service.getAll());
        model.addAttribute("user",new User());

        return "index";
    }


    @PostMapping("/add")
    public String add(@ModelAttribute User user){
        service.add(user);
        return "redirect:/user/all";
    }


    @GetMapping("/edit")
    public String editUse(@RequestParam Long id, Model model){
        Optional<User> user = service.getById(id);
        model.addAttribute("user",user);
        return "edit";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user){
        service.add(user);
        return "redirect:/user/all";
    }

    @GetMapping("/del")
    public String del(@RequestParam Long id){
        service.del(id);
        return "redirect:/user/all";}


    @GetMapping("/reg")
    public String reg(User user, Model model){

        return "regPage";
    }

    @GetMapping("/login/page")
    public String loginUser(Model model, @ModelAttribute("user") User data) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User data, HttpSession session) {
        System.out.println("ldfkgl;kjdsfilj;o o");
            session.setAttribute("user", data.getId());
            return "redirect:/user/all" + data.getId();
    }


    @PostMapping("/reg")
    public String CreateUser(User user, Model model){
        model.addAttribute("user",new User());
        service.createUser(user);
        return "redirect:/user/login/page";
    }
}
