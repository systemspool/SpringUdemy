package com.jesus.curso.springboot.webapp.springbootweb.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesus.curso.springboot.webapp.springbootweb.models.User;
import com.jesus.curso.springboot.webapp.springbootweb.models.dto.ParamDto;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;
   // @Value("${config.message}")
    //private String message;
    @Value("${config.listOfValues}")
    private String[] listOfValues;
    @Value("${config.code}")
    private Integer code;

    //otra forma de enviar mensajes por la ruta o alguno otro dato como parametro es con pathvariable
    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message){
        ParamDto param = new ParamDto();
        param.setMessage(message);  
        return param;
    }


//otra forma de enviar mensajes por la ruta o alguno otro dato como parametro es con pathvariable
//en este caso se estan enviando dos datos
//se ocupa para apis el pathvariable
    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id){
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user){
        //se crea el usuario

        return user;
    }

    //obtenemos datos directo del properties de spring el cual se configuro uno nuevo y se enlazo directo en el webaplicattion de java
    //agregando esta anotacion @PropertySource("classpath:nombre del properties") //se pueden tener varios propertis cambiando a propertysources
    @GetMapping("/values")
    public Map<String, Object> values(@Value("${config.message}") String message){
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("code", code);
        json.put("message", message);
        json.put("listOfValues", listOfValues);

        return json;
    }
}
