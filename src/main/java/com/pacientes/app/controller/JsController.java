package com.pacientes.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class JsController {
    @GetMapping("/js/index.js")
    public String indexJs(){
        return "/js/index.js";
    }
    @GetMapping("/js/addPac.js")
    public String addJs(){
        return "/js/addPac.js";
    }
     @GetMapping("/js/list.js")
    public String listJs(){
        return "/js/list.js";
    }
    @GetMapping("/js/consultarPac.js")
    public String consultarJs()
    {
        return "/js/consultarPac.js";
    }
    @GetMapping("/js/relatorio.js")
    public String relatorioJs()
    {
        return "/js/relatorio.js";
    }
    @GetMapping("/js/excluirPac.js")
    public String excluirJs()
    {
        return "/js/excluirPac.js";
    }
    @GetMapping("/js/alterarPac.js")
    public String alterarJs()
    {
        return "js/alterarPac.js";
    }
}
