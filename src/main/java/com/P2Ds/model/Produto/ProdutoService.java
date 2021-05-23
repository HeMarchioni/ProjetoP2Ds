package com.P2Ds.model.Produto;


import com.P2Ds.model.Cliente.Cliente;
import com.P2Ds.model.Cliente.ClienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {


    @Autowired
    ProdutoDAO pdao;

    public void inserirProduto(Produto produto) {
        pdao.inserirProduto(produto);
    }



}
