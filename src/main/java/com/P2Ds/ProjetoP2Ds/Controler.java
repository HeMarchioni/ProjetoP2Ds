package com.P2Ds.ProjetoP2Ds;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ComponentScan("com.P2Ds.model")      //--> VAI PROCURAR NA PASTA ANTES COM.MODEL
public class Controler {


    @Autowired
    private ApplicationContext context;


    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/placa")
    public String placa() {
        return "placa.html";
    }


}
