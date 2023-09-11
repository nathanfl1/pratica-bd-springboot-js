package com.pacientes.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
@GetMapping("/")
    public String index()
    {
        return "index.html";
    }
    @GetMapping("/cadastrar")
    public String cadastrar()
    {
        return "/addPac.html";
    }
    @GetMapping("/lista")
    public String lista()
    {
        return "/listPac.html";
    }
    @GetMapping("/consultar")
    public String consultar()
    {
        return "/consultarPac.html";
    }
    @GetMapping("/relatorio")
    public String relatorio()
    {
        return "/relatorio.html";
    }
    @GetMapping("/excluir")
    public String excluir()
    {
        return "/excluirPac.html";
    }
}   
