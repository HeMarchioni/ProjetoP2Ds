package com.P2Ds.model.Produto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;


@Repository
public class ProdutoDAO {


    @Autowired
    DataSource dataSource;


    JdbcTemplate jdbc;


    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }


    public void inserirProduto(Produto produto) {
        String sql = "INSERT INTO produto(nm_Produto,nm_Categoria,ds_Produto,vl_Produto) VALUES (?,?,?,?)" ;
        jdbc.update(sql, new Object[]{
                produto.getNm_Produto(),
                produto.getNm_Categoria(),
                produto.getDs_Produto(),
                produto.getVl_Produto()
        });
    }




}
