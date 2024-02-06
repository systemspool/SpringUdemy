package com.jesus.curso.springboot.webapp.springbootweb.controllers;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesus.curso.springboot.webapp.springbootweb.models.User;
import com.jesus.curso.springboot.webapp.springbootweb.models.dto.UserDto;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details(){
        UserDto userDto = new UserDto();
        User user = new User("Jesus", "Anaya");
        //primera opcion pasandole el user
        userDto.setUser(user);
        userDto.setTitle("User desde DTO");
        //segunda opcion pasandole los datos separados concatenados
        userDto.setName(user.getName());
        userDto.setLastName(user.getLastName());
        //tercera opcion en al cual con una variable en el dto que es full name. concatenamos el nombre y apellido opteniendolos desde la clase user
        userDto.setFullName(user.getName().concat(" ").concat(user.getLastName()));


        return userDto;        
    }

    @GetMapping("/list")
    public List<User> list(){
        User user = new User("Jesus", "Anaya");
        User user2 = new User("Antonio", "Mendez");
        User user3 = new User("Jose", "Martinez");

        //primera opcion de lista
        //List<User> users = new ArrayList<>();
        //users.add(user);
        //users.add(user2);
        //users.add(user3);

        //Segunda opcion de lista con la clase helpers
        List<User> users = Arrays.asList(user,user2,user3);

        return users;
    }
    

    @GetMapping("/details-map")
    public Map<String, Object> detailsMap(){
        User user = new User("Andres", "Diaz");
        Map<String, Object> body = new HashMap<>();
        body.put("title", "Hola Mundo SpringBoot");
        body.put("user", user);
        return body;
    }

}