package com.P2Ds.model.Usuario;


import com.P2Ds.model.Fornecedor.Fornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Map;

@Repository
public class UsuarioDAO {


    @Autowired
    DataSource dataSource;

    @Autowired
    PasswordEncoder passwordEncoder;


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


    public void alterarSenha(Usuario usuario) {     // -> alterar senha no banco de dados
        if (usuario.getAuthority().contentEquals("USER")) {     // -> se for cliente
            String sql = "UPDATE cliente SET cd_Senha = ? WHERE cd_Cliente = ?";
            jdbc.update(sql, new Object[]{
                    passwordEncoder.encode(usuario.getCd_Senha()),
                    usuario.getCd_Usuario()
            });
        } else {                                 // -> se for Funcionario
            String sql = "UPDATE Funcionario SET cd_Senha = ? WHERE cd_Funcionario = ?";
            jdbc.update(sql, new Object[]{
                    passwordEncoder.encode(usuario.getCd_Senha()),
                    usuario.getCd_Usuario()
            });
        }
    }


}




