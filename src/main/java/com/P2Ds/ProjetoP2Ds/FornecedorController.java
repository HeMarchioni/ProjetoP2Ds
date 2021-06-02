package com.P2Ds.ProjetoP2Ds;


import com.P2Ds.model.Fornecedor.Fornecedor;
import com.P2Ds.model.Fornecedor.FornecedorService;
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
@ComponentScan("com.P2Ds.model")  //--> VAI PROCURAR NA PASTA COM.MODEL
public class FornecedorController {


    @Autowired
    private ApplicationContext context;

    @GetMapping("/cadastroFornecedor")
    public String cadastrarFornecedor(Model model) {
        model.addAttribute("fornecedor",new Fornecedor());
        return "cadastroFornecedor";
    }

    @PostMapping("/cadastroFornecedor")   // -> cadastrar Fornecedor no banco de dados
    public String postProduto(@ModelAttribute Fornecedor fornecedor,
                              Model model) {
        FornecedorService fornService = context.getBean(FornecedorService.class);
        fornService.inserirFornecedor(fornecedor);
        return "sucesso";
    }


    @GetMapping("/busca/{cd_Fornecedor}")   // -> busca somente pelo codigo
    public String buscaId(@PathVariable("cd_Fornecedor") int cd_Fornecedor, Model model){
        FornecedorService fornService = context.getBean(FornecedorService.class);
        Map<String,Object> FornecedorMap = fornService.getCd_Fornecedor(cd_Fornecedor);
        Fornecedor fornecedor = new Fornecedor((int)FornecedorMap.get("cd_Fornecedor"),(String) FornecedorMap.get("nm_Fornecedor"),(String) FornecedorMap.get("nm_Produto"),
                (String) FornecedorMap.get("ds_Fornecedor"),(String) FornecedorMap.get("nm_Contato"),(String)FornecedorMap.get("cd_Telefone"),(String)FornecedorMap.get("ds_Email"));
        model.addAttribute("forne",fornecedor);
        return "produtosucesso";
    }


    @GetMapping("/listarFornecedores")     // -> pega a lista de todos os Fornecedores cadastrados
    public String listarFornecedores(Model model) {
        FornecedorService fornService = context.getBean(FornecedorService.class);
        List<Map<String,Object>> fornecedores = fornService.getListafornecedores();
        model.addAttribute("fornecedores", fornecedores);
        return "fornecedoresLista";
    }

    @PostMapping("/apagarForn/{cd_Fornecedor}")    // -> apagar fornecedor no banco de dados
    public String deletar(@PathVariable("cd_Fornecedor") int cd_Fornecedor, Model model) {
        FornecedorService fornService = context.getBean(FornecedorService.class);
        fornService.deleteFornecedor(cd_Fornecedor);
        return "redirect:/listarFornecedores";
    }


    /*================== atualizar produto ==============================================*/

    @GetMapping("/updForn/{cd_Fornecedor}")                                               // -> atualizar dados do fornecedor no banco
    public String updateForm(@PathVariable("cd_Fornecedor") int cd_Fornecedor, Model model){
        FornecedorService fornService = context.getBean(FornecedorService.class);
        Map<String,Object> antigo = fornService.getCd_Fornecedor(cd_Fornecedor);
        Fornecedor ForneAntigo = new Fornecedor((int)antigo.get("cd_Fornecedor"),(String) antigo.get("nm_Fornecedor"),(String) antigo.get("nm_Produto"),
                (String) antigo.get("ds_Fornecedor"),(String) antigo.get("nm_Contato"),(String)antigo.get("cd_Telefone"),(String)antigo.get("ds_Email"));
        model.addAttribute("antigo", ForneAntigo);
        model.addAttribute("cd_Fornecedor", cd_Fornecedor);
        return "atualizacaoFornecedor";
    }

    @PostMapping("/updForn/{cd_Fornecedor}")
    public String update(@PathVariable("cd_Fornecedor") int cd_Fornecedor, @ModelAttribute Fornecedor fornecedor, Model model) {
        FornecedorService fornService = context.getBean(FornecedorService.class);
        fornService.updateFornecedor(cd_Fornecedor, fornecedor);
        return "redirect:/listarFornecedores";
    }




}
