package com.P2Ds.ProjetoP2Ds.Controllers;


import com.P2Ds.model.Cliente.Cliente;
import com.P2Ds.model.Cliente.ClienteService;
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
public class ClienteController {


    @Autowired
    private ApplicationContext context;


    // ============Cadastro Cliente =========================================================================

    @GetMapping("/cadastro")         // -> Caminho para cadastro de cliente
    public String formCliente(Model model) {
        model.addAttribute("cliente",new Cliente());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String postCliente(@ModelAttribute Cliente cli,
                              Model model) {
        ClienteService cs = context.getBean(ClienteService.class);
        if (cs.verificaEmail(cli.getDs_Email()) || cs.verificaEmail2(cli.getDs_Email())) {
            return "CadastroInvalido";
        } else {
            cs.inserirCliente(cli);
            return "sucesso";
        }

    }




}
