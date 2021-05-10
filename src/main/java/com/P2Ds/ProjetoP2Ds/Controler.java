package com.P2Ds.ProjetoP2Ds;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controler {

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/placa")
    public String placa() {
        return "placa.html";
    }


}
