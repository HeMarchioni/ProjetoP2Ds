package com.P2Ds.model;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;


@Repository
public class ClienteDAO {


    @Autowired
    DataSource dataSource;


    @Autowired
    PasswordEncoder passwordEncoder;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }




    public void inserirCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente(cd_Cpf,nm_Cliente,ds_Email,ds_Endereco,ds_Cidade,sg_Uf,cd_Cep,cd_Telefone,cd_Senha)" +
                " VALUES (?,?,?,?,?,?,?,?,?)";
        Object[] obj = new Object[9];

        obj[0] = cliente.getCd_Cpf();
        obj[1] = cliente.getNm_Cliente();
        obj[2] = cliente.getDs_Email();
        obj[3] = cliente.getDs_Endereco();
        obj[4] = cliente.getDs_Cidade();
        obj[5] = cliente.getSg_Uf();
        obj[6] = cliente.getCd_Cep();
        obj[7] = cliente.getCd_Telefone();
        obj[8] = passwordEncoder.encode(cliente.getCd_Senha());
        jdbc.update(sql, obj);
    }




}