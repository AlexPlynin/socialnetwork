package com.newsweaterproject.controller;

import com.newsweaterproject.domain.Message;
import com.newsweaterproject.repos.MessageRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepos messageRepos;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {

        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepos.findAll();            //получаем данные с репозитория
        model.put("messages", messages);                                //пробрасываем в вид


        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {

        Message message = new Message(text, tag);
        messageRepos.save(message);

        Iterable<Message> messages = messageRepos.findAll();            //получаем данные с репозитория
        model.put("messages", messages);                                //пробрасываем в вид


        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;
        if (filter != null && !filter.isEmpty()) { //добавление условия по фильтрам


            messages = messageRepos.findByTag(filter);
        } else {
            messages = messageRepos.findAll();
        }
        model.put("messages", messages);

        return "main";
    }
}
