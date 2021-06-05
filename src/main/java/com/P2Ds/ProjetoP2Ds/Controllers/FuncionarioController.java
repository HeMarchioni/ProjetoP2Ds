package com.P2Ds.ProjetoP2Ds.Controllers;



import com.P2Ds.model.Funcionario.Funcionario;
import com.P2Ds.model.Funcionario.FuncionarioService;
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
public class FuncionarioController {


    @Autowired
    private ApplicationContext context;


    // ============Cadastro Funcionario =========================================================================

    @GetMapping("/cadastroFuncionario")         // -> Caminho para cadastro de Funcionario
    public String cadastrarFuncionario(Model model) {
        model.addAttribute("funcionario",new Funcionario());
        return "cadastroFuncionario";
    }

    @PostMapping("/cadastroFuncionario")
    public String postFuncionario(@ModelAttribute Funcionario funcionario,
                              Model model) {
        FuncionarioService funcionarioService = context.getBean(FuncionarioService.class);
        funcionarioService.inserirFuncionario(funcionario);
        return "sucesso";
    }



}
