package com.newsweaterproject.controller;

import com.newsweaterproject.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //спринг через МэйнСервлет будет передавать запросы именно этому контролерру при востребовании
public class RegistrationController {

    @GetMapping("/registration")
    public String registration() {


        return "registration";
    }

    @PostMapping("/registration") //маппинг для гет зпросов
    public String addUser(User user){//для поиска пользователя необходимо создать репозитроий UserRepo


        return "/redirect:/login";//при успешной авторизации редирект на форму логина
    }

}
