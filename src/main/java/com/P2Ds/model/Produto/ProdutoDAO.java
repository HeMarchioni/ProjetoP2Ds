package com.P2Ds.model.Produto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;


@Repository
public class ProdutoDAO {


    @Autowired
    DataSource dataSource;


    JdbcTemplate jdbc;


    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }


    public void inserirProduto(Produto produto) {     // -> cadastrar produto no banco de dados
        String sql = "INSERT INTO produto(nm_Produto,nm_Categoria,ds_Produto,vl_Produto) VALUES (?,?,?,?)" ;
        jdbc.update(sql, new Object[]{
                produto.getNm_Produto(),
                produto.getNm_Categoria(),
                produto.getDs_Produto(),
                produto.getVl_Produto()
        });
    }

    public Map<String, Object> getCd_Produto(int cd_Produto) {               // -> busca somente pelo codigo
        String sql = "SELECT * FROM produto WHERE produto.cd_Produto = ?";
        return jdbc.queryForMap(sql,new Object[] {cd_Produto});
    }



    public List<Map<String, Object>> getListaProdutos() {          // -> pega a lista de todos os produtos cadastrados
        String sql = "SELECT * FROM produto";
        List<Map<String, Object>> produtos = (List<Map<String, Object>>) jdbc.queryForList(sql);
        return produtos;
    }


    public void deleteProduto(int cd_Produto) {       // -> apagar produto no banco de dados
        String sql = "DELETE FROM produto WHERE cd_Produto = ?" ;
        jdbc.update(sql, new Object[] {cd_Produto});
    }



    public void updateProduto(int cd_Produto,Produto produto) {   // -> atualizar dados do produto no banco
        String sql = "UPDATE produto SET nm_Produto = ?, nm_Categoria = ?, ds_Produto = ?, vl_Produto = ?  WHERE cd_Produto = ?";
        jdbc.update(sql, new Object[]{
                produto.getNm_Produto(), produto.getNm_Categoria(),produto.getDs_Produto(),produto.getVl_Produto(),cd_Produto
        });
    }





}
