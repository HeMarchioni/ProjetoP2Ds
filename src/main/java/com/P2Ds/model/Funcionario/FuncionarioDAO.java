package com.P2Ds.model.Funcionario;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

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
        obj[9] = passwordEncoder.encode(funcionario.getDs_Email());
        obj[10] = funcionario.getAuthority();
        jdbc.update(sql, obj);
    }


    public List<Map<String, Object>> getListaFuncionarios() {          // -> pega a lista de todos os Funcionarioes cadastrados
        String sql = "SELECT * FROM funcionario";
        List<Map<String, Object>> Funcionarios = (List<Map<String, Object>>) jdbc.queryForList(sql);
        return Funcionarios;
    }


    public void deleteFuncionario(int cd_Funcionario) {       // -> apagar funcionario no banco de dados
        String sql = "DELETE FROM funcionario WHERE cd_Funcionario = ?" ;
        jdbc.update(sql, new Object[] {cd_Funcionario});
    }



    public Map<String, Object> getCd_Funcionario(int cd_Funcionario) {               // -> busca somente pelo codigo
        String sql = "SELECT * FROM funcionario WHERE cd_Funcionario = ?";
        return jdbc.queryForMap(sql,new Object[] {cd_Funcionario});
    }


    public void updateFuncionario(int cd_Funcionario, Funcionario funcionario) {   // -> atualizar dados do funcionario no banco
        String sql = "UPDATE funcionario SET ds_Email = ?, cd_Telefone = ?, cd_Cep = ? , ds_Endereco = ?, ds_Cidade = ?, sg_Uf = ?, ds_Cargo = ?, authority = ?, enabled = ? WHERE cd_Funcionario = ?";
        jdbc.update(sql, new Object[]{
                funcionario.getDs_Email(),
                funcionario.getCd_Telefone(),
                funcionario.getCd_Cep(),
                funcionario.getDs_Endereco(),
                funcionario.getDs_Cidade(),
                funcionario.getSg_Uf(),
                funcionario.getDs_Cargo(),
                funcionario.getAuthority(),
                funcionario.isEnabled(),
                cd_Funcionario
        });
    }




}
