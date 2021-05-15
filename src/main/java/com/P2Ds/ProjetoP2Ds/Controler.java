package com.P2Ds.ProjetoP2Ds;


import com.P2Ds.model.Cliente;
import com.P2Ds.model.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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


    @GetMapping("/cliente")
    public String formCliente(Model model) {
        model.addAttribute("cliente",new Cliente());
        return "cadastro";
    }

    @PostMapping("/cliente")
    public String postCliente(@ModelAttribute Cliente cli,
                              Model model) {
        ClienteService cs = context.getBean(ClienteService.class);
        cs.inserirCliente(cli);
        return "sucesso";
    }




}
