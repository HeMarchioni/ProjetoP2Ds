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
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@ComponentScan("com.P2Ds.model")  //--> VAI PROCURAR NA PASTA COM.MODEL.PRODUTO
public class ProdutoController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/cadastroProduto")
    public String cadastrarProduto(Model model) {
        model.addAttribute("produto",new Produto());
        return "cadastroProduto";
    }

    @PostMapping("/cadastroProduto")
    public String postProduto(@ModelAttribute Produto produto,
                              Model model) {
        ProdutoService prodService = context.getBean(ProdutoService.class);
        prodService.inserirProduto(produto);
        return "sucesso";
    }




}
