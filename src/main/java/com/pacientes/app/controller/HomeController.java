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
        return "/html/index.html";
    }
    @GetMapping("/cadastrar")
    public String cadastrar()
    {
        return "/html/addPac.html";
    }
    @GetMapping("/lista")
    public String lista()
    {
        return "/html/listPac.html";
    }
    @GetMapping("/consultar")
    public String consultar()
    {
        return "/html/consultarPac.html";
    }
    @GetMapping("/relatorio")
    public String relatorio()
    {
        return "/html/relatorio.html";
    }
    @GetMapping("/excluir")
    public String excluir()
    {
        return "/html/excluirPac.html";
    }
    @GetMapping("/alterar")
    public String alterar()
    {
        return "/html/alterarPac.html";
    }
}   
