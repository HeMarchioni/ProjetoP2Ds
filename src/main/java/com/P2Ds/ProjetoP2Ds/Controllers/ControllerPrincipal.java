package com.P2Ds.ProjetoP2Ds.Controllers;

import com.P2Ds.model.Contato.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
@ComponentScan("com.P2Ds.model")      //--> VAI PROCURAR NA PASTA ANTES COM.MODEL
public class ControllerPrincipal {


    @Autowired
    private ApplicationContext context;


    // =========== Pagina Principal =============================================================
    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/detalheProd")
    public String detalheProd() {
        return "produto.html";
    }

    // ============ Sobre ====================================================================

    @GetMapping("/sobre")
    public String sobreAcme() {
        return "sobre.html";
    }

    // - Parte login -==================================================

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }


    // - pagina Contato ==============================================

    @GetMapping("/contato")
    public String contato(Model model) {
        model.addAttribute("contato",new Contato());
        return "contato.html";
    }

/*  Em Contrução
    @PostMapping("/contato")
    public String postContato(@ModelAttribute Contato contato,
                              Model model) {

        return "sucesso";
    }
 */

}
