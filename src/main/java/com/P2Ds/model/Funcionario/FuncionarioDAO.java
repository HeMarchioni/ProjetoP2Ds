package com.P2Ds.model.Funcionario;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class FuncionarioDAO {


    @Autowired
    DataSource dataSource;

    @Autowired
    PasswordEncoder passwordEncoder;


    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }


    public void inserirFuncionario(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario(cd_Cpf,nm_Funcionario,ds_Cargo,ds_Email,ds_Endereco,ds_Cidade,sg_Uf,cd_Cep,cd_Telefone,cd_Senha,authority)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        Object[] obj = new Object[11];

        obj[0] = funcionario.getCd_Cpf();
        obj[1] = funcionario.getNm_Funcionario();
        obj[2] = funcionario.getDs_Cargo();
        obj[3] = funcionario.getDs_Email();
        obj[4] = funcionario.getDs_Endereco();
        obj[5] = funcionario.getDs_Cidade();
        obj[6] = funcionario.getSg_Uf();
        obj[7] = funcionario.getCd_Cep();
        obj[8] = funcionario.getCd_Telefone();
        obj[9] = passwordEncoder.encode(funcionario.getCd_Senha());
        obj[10] = funcionario.getCd_Telefone();
        jdbc.update(sql, obj);
    }




}
