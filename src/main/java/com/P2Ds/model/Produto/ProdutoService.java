package com.P2Ds.model.Produto;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProdutoService {


    @Autowired
    ProdutoDAO pdao;

    public void inserirProduto(Produto produto) {
        pdao.inserirProduto(produto);
    }    // -> cadastrar produto no banco de dados

    public Map<String, Object> getCd_Produto(int cd_Produto) {
        return pdao.getCd_Produto(cd_Produto);
    }  // -> busca somente pelo codigo


    public List<Map<String, Object>> getListaProdutos() {
        return pdao.getListaProdutos();
    }  // -> pega a lista de todos os produtos cadastrados


    public void deleteProduto(int cd_Produto) {
        pdao.deleteProduto(cd_Produto);
    }  // -> apagar produto no banco de dados


    public void updateProduto(int cd_Produto, Produto produto) {
        pdao.updateProduto(cd_Produto, produto);
    } // -> atualizar dados do produto no banco


}
