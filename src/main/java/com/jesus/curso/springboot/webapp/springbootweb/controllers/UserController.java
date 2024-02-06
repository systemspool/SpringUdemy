package com.jesus.curso.springboot.webapp.springbootweb.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jesus.curso.springboot.webapp.springbootweb.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){
        User user = new User("Andres", "Diaz");
        user.setEmail("andres@gmail.com");
        model.addAttribute("title", "Hola Mundo SpringBoot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(Model model){
        
        model.addAttribute("title", "Listado de usuarios");
        //model.addAttribute("users", users);
        return "list";
    }

    
    @ModelAttribute("users")
    public List<User> usersModel(){
        List<User> users = Arrays.asList(new User("Jose", "Mendez"),
        new User("Jorge", "Diaz"), new User("Andres", "Ruiz","andres@gmail.com"));
        return users;
    }

}
