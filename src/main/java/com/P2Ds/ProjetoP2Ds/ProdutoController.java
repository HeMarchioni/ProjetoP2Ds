package com.P2Ds.ProjetoP2Ds;


import com.P2Ds.model.Produto.Produto;
import com.P2Ds.model.Produto.ProdutoService;
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
public class ProdutoController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/cadastroProduto")
    public String cadastrarProduto(Model model) {
        model.addAttribute("produto",new Produto());
        return "cadastroProduto";
    }

    @PostMapping("/cadastroProduto")   // -> cadastrar produto no banco de dados
    public String postProduto(@ModelAttribute Produto produto,
                              Model model) {
        ProdutoService prodService = context.getBean(ProdutoService.class);
        prodService.inserirProduto(produto);
        return "sucesso";
    }


    @GetMapping("/busca/{cd_Produto}")   // -> busca somente pelo codigo
    public String buscaId(@PathVariable("cd_Produto") int cd_Produto, Model model){
        ProdutoService prodService = context.getBean(ProdutoService.class);
        Map<String,Object> produtoMap = prodService.getCd_Produto(cd_Produto);
        Produto produto = new Produto((int)produtoMap.get("cd_Produto"),(String)produtoMap.get("nm_Produto"),
                (String)produtoMap.get("nm_Categoria"),(String)produtoMap.get("ds_Produto"),(float)produtoMap.get("vl_Produto"));
        model.addAttribute("prod",produto);
        return "produtosucesso";
    }


    @GetMapping("/listarProdutos")     // -> pega a lista de todos os produtos cadastrados
    public String listarProdutos(Model model) {
        ProdutoService prodService = context.getBean(ProdutoService.class);
        List<Map<String,Object>> produtos = prodService.getListaProdutos();
        model.addAttribute("produtos",produtos);
        return "formlista";
    }

    @PostMapping("/apagar/{cd_Produto}")    // -> apagar produto no banco de dados
    public String deletar(@PathVariable("cd_Produto") int cd_Produto,Model model) {
        ProdutoService prodService = context.getBean(ProdutoService.class);
        prodService.deleteProduto(cd_Produto);
        return "redirect:/listarProdutos";
    }


    /*================== atualizar produto ==============================================*/

    @GetMapping("/upd/{cd_Produto}")                                               // -> atualizar dados do produto no banco
    public String updateForm(@PathVariable("cd_Produto") int cd_Produto, Model model){
        ProdutoService prodService = context.getBean(ProdutoService.class);
        Map<String,Object> antigo = prodService.getCd_Produto(cd_Produto);
        Produto prodAntigo = new Produto((int)antigo.get("cd_Produto"),(String)antigo.get("nm_Produto"),
                (String)antigo.get("nm_Categoria"),(String)antigo.get("ds_Produto"),(float)antigo.get("vl_Produto"));
        model.addAttribute("antigo",prodAntigo);
        model.addAttribute("cd_Produto",cd_Produto);
        return "atualizacaoProduto";
    }

    @PostMapping("/upd/{cd_Produto}")
    public String update(@PathVariable("cd_Produto") int cd_Produto, @ModelAttribute Produto produto, Model model) {
        ProdutoService prodService = context.getBean(ProdutoService.class);
        prodService.updateProduto(cd_Produto, produto);
        return "redirect:/listarProdutos";
    }



}
