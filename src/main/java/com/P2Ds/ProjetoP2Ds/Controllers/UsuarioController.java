package com.P2Ds.ProjetoP2Ds.Controllers;


import com.P2Ds.model.Usuario.Usuario;
import com.P2Ds.model.Usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;


@Controller
@ComponentScan("com.P2Ds.model")      //--> VAI PROCURAR NA PASTA ANTES COM.MODEL
public class UsuarioController {


    @Autowired
    private ApplicationContext context;
    private String user;




    // ====================================== Pagina logado -> pegando Usuario da sessão ================================
    @GetMapping("/logado")
    public String logado(Model model) {
        UsuarioService usuarioService = context.getBean(UsuarioService.class);
        user = usuarioService.getUserEmail();


        try {


            Map<String,Object> usuarioMap = usuarioService.getUsuarioFuncionario(user);                  // -> Se for Funcionario
            Usuario usuario = new Usuario((int)usuarioMap.get("cd_Funcionario"),(String)usuarioMap.get("cd_Cpf"),
                    (String)usuarioMap.get("nm_Funcionario"),(String) usuarioMap.get("ds_Cargo"),(String) usuarioMap.get("ds_Email"),
                    (String) usuarioMap.get("ds_Endereco"),(String) usuarioMap.get("ds_Cidade"),(String) usuarioMap.get("sg_Uf"),
                    (String) usuarioMap.get("cd_Cep"),(String) usuarioMap.get("cd_Telefone"));

            model.addAttribute("usuario", usuario);


        } catch (Exception e) {
            try {
                Map<String, Object> usuarioMap = usuarioService.getUsuarioCliente(user);                  // -> Se for Cliente
                Usuario usuario = new Usuario((int) usuarioMap.get("cd_Cliente"), (String) usuarioMap.get("cd_Cpf"),
                        (String) usuarioMap.get("nm_Cliente"), (String) usuarioMap.get("ds_Email"),
                        (String) usuarioMap.get("ds_Endereco"), (String) usuarioMap.get("ds_Cidade"), (String) usuarioMap.get("sg_Uf"),
                        (String) usuarioMap.get("cd_Cep"), (String) usuarioMap.get("cd_Telefone"));

                model.addAttribute("usuario", usuario);
            } catch (Exception e2) {                                                 // -> Se for Usuario Master
                Usuario usuario = new Usuario();
                usuario.setNm_Usuario("Master");
                model.addAttribute("usuario",usuario);

            }
        }

        return "logado.html";
    }



}
