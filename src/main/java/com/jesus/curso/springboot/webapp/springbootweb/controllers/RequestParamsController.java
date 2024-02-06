package com.jesus.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jesus.curso.springboot.webapp.springbootweb.models.dto.ParamDto;
import com.jesus.curso.springboot.webapp.springbootweb.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    //para pasar parametros por la url se ocupa requestparam y el mensaje se manda por la url esepcificando el parametro
    //http://localhost:8090/api/params/bar?text=pasando%20dos%20datos
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "No tiene datos") String message){
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }


    //para pasar varios parametros en la url se concatenan con el and (&)
    //http://localhost:8090/api/params/bar?text=pasando%20dos%20datos&code=1234
    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code){
        ParamMixDto params = new ParamMixDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }

    //se crea un get por el cual le pasamos parametros ocupando http
    //validamos con un try catch que el valor sea numerico si no mande una excepcion y le de por defaul el valor 0
    @GetMapping("request")
    public ParamMixDto request(HttpServletRequest request){
        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {

        }
        ParamMixDto params = new ParamMixDto();
        params.setCode(code);
        params.setMessage(request.getParameter("message"));
        return params;
    }

}
