package com.P2Ds.model.Fornecedor;


import com.P2Ds.model.Produto.Produto;
import com.P2Ds.model.Produto.ProdutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FornecedorService {


    @Autowired
    FornecedorDAO fdao;

    public void inserirFornecedor(Fornecedor fornecedor) {
        fdao.inserirFornecedor(fornecedor);
    }    // -> cadastrar fornecedor no banco de dados

    public Map<String, Object> getCd_Fornecedor(int cd_Fornecedor) {
        return fdao.getCd_Fornecedor(cd_Fornecedor);
    }  // -> busca somente pelo codigo


    public List<Map<String, Object>> getListafornecedores() {
        return fdao.getListaFornecedores();
    }  // -> pega a lista de todos os fornecedores cadastrados


    public void deleteFornecedor(int cd_Fornecedor) {
        fdao.deleteFornecedor(cd_Fornecedor);
    }  // -> apagar fornecedor no banco de dados


    public void updateFornecedor(int cd_Fornecedor, Fornecedor fornecedor) {
        fdao.updateFornecedor(cd_Fornecedor, fornecedor);
    } // -> atualizar dados do fornecedor no banco



}
