package com.P2Ds.model.Fornecedor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class FornecedorDAO {


    @Autowired
    DataSource dataSource;


    JdbcTemplate jdbc;


    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }



    public void inserirFornecedor(Fornecedor fornecedor) {     // -> cadastrar fornecedor no banco de dados
        String sql = "INSERT INTO Fornecedor(nm_Fornecedor,nm_Produto,ds_Fornecedor,nm_Contato,cd_Telefone,ds_Email) VALUES (?,?,?,?,?,?)" ;
        jdbc.update(sql, new Object[]{
                fornecedor.getNm_Fornecedor(),
                fornecedor.getNm_Produto(),
                fornecedor.getDs_Fornecedor(),
                fornecedor.getNm_Contato(),
                fornecedor.getCd_Telefone(),
                fornecedor.getDs_Email()
        });
    }

    public Map<String, Object> getCd_Fornecedor(int cd_Fornecedor) {               // -> busca somente pelo codigo
        String sql = "SELECT * FROM fornecedor WHERE fornecedor.cd_Fornecedor = ?";
        return jdbc.queryForMap(sql,new Object[] {cd_Fornecedor});
    }



    public List<Map<String, Object>> getListaFornecedores() {          // -> pega a lista de todos os Fornecedores cadastrados
        String sql = "SELECT * FROM fornecedor";
        List<Map<String, Object>> Fornecedores = (List<Map<String, Object>>) jdbc.queryForList(sql);
        return Fornecedores;
    }


    public void deleteFornecedor(int cd_Fornecedor) {       // -> apagar fornecedor no banco de dados
        String sql = "DELETE FROM fornecedor WHERE cd_Fornecedor = ?" ;
        jdbc.update(sql, new Object[] {cd_Fornecedor});
    }



    public void updateFornecedor(int cd_Fornecedor,Fornecedor fornecedor) {   // -> atualizar dados do fornecedor no banco
        String sql = "UPDATE Fornecedor SET nm_Fornecedor = ?, nm_Produto = ?, ds_Fornecedor = ?, nm_Contato = ? , cd_Telefone = ?, ds_Email = ? WHERE cd_Fornecedor = ?";
        jdbc.update(sql, new Object[]{
                fornecedor.getNm_Fornecedor(),
                fornecedor.getNm_Produto(),
                fornecedor.getDs_Fornecedor(),
                fornecedor.getNm_Contato(),
                fornecedor.getCd_Telefone(),
                fornecedor.getDs_Email(),
                cd_Fornecedor
        });
    }






}
