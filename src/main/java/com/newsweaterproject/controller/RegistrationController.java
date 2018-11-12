package com.newsweaterproject.controller;

import com.newsweaterproject.domain.Role;
import com.newsweaterproject.domain.User;
import com.newsweaterproject.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller //спринг через МэйнСервлет будет передавать запросы именно этому контролерру при востребовании
public class RegistrationController {
    @Autowired
    private UserRepo userRepo; // сприг кидает инЪекцию))
    @GetMapping("/registration")
    public String registration() {


        return "registration";
    }

    @PostMapping("/registration") //маппинг для гет зпросов
    public String addUser(User user, Map<String,Object> model){//для поиска пользователя необходимо создать репозитроий UserRepo

        User userFromDb = userRepo.findByUsername(user.getUsername());//получаем юзера из базы
        if (userFromDb!=null){
            model.put("message","User exist!");
            return "registration";  //если пользователь есть то возвращем вью регистрации

        }
        //Если пользователя нет
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));//создание сета с одним значением
        userRepo.save(user);//сохранение пользователя

        return "redirect:/login";//при успешной авторизации редирект на форму логина
    }

}
