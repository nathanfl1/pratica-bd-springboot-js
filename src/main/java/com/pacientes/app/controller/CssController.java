package com.pacientes.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CssController {
    @GetMapping("/css/index.css")
    public String getCss() {
        return "/css/index.css";
    }

    @GetMapping("/css/list.css")
    public String getListCss() {
        return "/css/list.css";
    }

    @GetMapping("/css/alterar.css")
    public String getAlterarCss() {
        return "/css/alterar.css";
    }
}
