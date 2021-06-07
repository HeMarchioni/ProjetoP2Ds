package com.P2Ds.model.Usuario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Map;

@Repository
public class UsuarioDAO {


    @Autowired
    DataSource dataSource;



    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }


    public Map<String, Object> getUsuarioFuncionario(String ds_Email) {               // -> busca somente para funcionarios pelo codigo
        String sql = "SELECT * FROM funcionario WHERE ds_Email = ?";
        return jdbc.queryForMap(sql,new Object[] {ds_Email});
    }

    public Map<String, Object> getUsuarioCliente(String ds_Email) {               // -> busca somente pelo clientes codigo
        String sql = "SELECT * FROM cliente WHERE ds_Email = ?";
        return jdbc.queryForMap(sql,new Object[] {ds_Email});
    }

}
