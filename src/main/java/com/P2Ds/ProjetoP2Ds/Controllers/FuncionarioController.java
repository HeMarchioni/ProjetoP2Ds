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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;


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


    // ===========================================================================================================


    @GetMapping("/listarFuncionario")     // -> pega a lista de todos os Funcionarios cadastrados
    public String listarFuncionarios(Model model) {
        FuncionarioService funcionarioService = context.getBean(FuncionarioService.class);
        List<Map<String,Object>> funcionarios = funcionarioService.getListaFuncionarios();
        model.addAttribute("funcionarios", funcionarios);
        return "funcionariosLista";
    }


   // ==================== Apagar =====================================================================================



    @PostMapping("/apagarFunci/{cd_Funcionario}")    // -> apagar produto no banco de dados
    public String deletarFuncionario(@PathVariable("cd_Funcionario") int cd_Funcionario,Model model) {
        FuncionarioService funcionarioService = context.getBean(FuncionarioService.class);
        funcionarioService.deleteFuncionario(cd_Funcionario);
        return "redirect:/listarFuncionario";
    }


    /*================== atualizar produto ==============================================*/

    @GetMapping("/updFunci/{cd_Funcionario}")                                               // -> atualizar dados dos Funcionarios no banco
    public String updateForm(@PathVariable("cd_Funcionario") int cd_Funcionario, Model model){
        FuncionarioService funcionarioService = context.getBean(FuncionarioService.class);
        Map<String,Object> antigo = funcionarioService.getCd_Funcionario(cd_Funcionario);
        Funcionario funceAntigo = new Funcionario((int)antigo.get("cd_Funcionario"),(String)antigo.get("cd_Cpf"),(String) antigo.get("nm_Funcionario"),
                (String) antigo.get("ds_Cargo"),(String) antigo.get("ds_Email"),(String) antigo.get("ds_Endereco"),(String) antigo.get("ds_Cidade"),
                (String) antigo.get("sg_Uf"),(String) antigo.get("cd_Cep"),(String) antigo.get("cd_Telefone"),(String) antigo.get("authority"),(boolean) antigo.get("enabled"));
        model.addAttribute("antigo",funceAntigo);
        model.addAttribute("cd_Funcionario",cd_Funcionario);
        return "atualizacaoFuncionario";
    }

    @PostMapping("/updFunci/{cd_Funcionario}")
    public String update(@PathVariable("cd_Funcionario") int cd_Funcionario, @ModelAttribute Funcionario funcionario, Model model) {
        FuncionarioService funcionarioService = context.getBean(FuncionarioService.class);
        funcionarioService.updateFuncionario(cd_Funcionario, funcionario);
        return "redirect:/listarFuncionario";
    }



}
