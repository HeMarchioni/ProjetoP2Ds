package com.P2Ds.ProjetoP2Ds.Controllers;


import com.P2Ds.model.Fornecedor.Fornecedor;
import com.P2Ds.model.Fornecedor.FornecedorService;
import com.P2Ds.model.Funcionario.Funcionario;
import com.P2Ds.model.Funcionario.FuncionarioService;
import com.P2Ds.model.Usuario.Usuario;
import com.P2Ds.model.Usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;


@Controller
@ComponentScan("com.P2Ds.model")      //--> VAI PROCURAR NA PASTA ANTES COM.MODEL
public class UsuarioController {


    @Autowired
    private ApplicationContext context;
    private String userEmail;
    private Usuario user;



    // ====================================== Pagina logado -> pegando Usuario da sessão ================================
    @GetMapping("/logado")
    public String logado(Model model) {
        UsuarioService usuarioService = context.getBean(UsuarioService.class);
        userEmail = usuarioService.getUserEmail();


        try {


            Map<String,Object> usuarioMap = usuarioService.getUsuarioFuncionario(userEmail);                  // -> Se for Funcionario
            Usuario usuario = new Usuario((int)usuarioMap.get("cd_Funcionario"),(String)usuarioMap.get("cd_Cpf"),
                    (String)usuarioMap.get("nm_Funcionario"),(String) usuarioMap.get("ds_Cargo"),(String) usuarioMap.get("ds_Email"),
                    (String) usuarioMap.get("ds_Endereco"),(String) usuarioMap.get("ds_Cidade"),(String) usuarioMap.get("sg_Uf"),
                    (String) usuarioMap.get("cd_Cep"),(String) usuarioMap.get("cd_Telefone"),(String) usuarioMap.get("authority"));

            user = usuario;
            model.addAttribute("usuario", usuario);


        } catch (Exception e) {
            try {
                Map<String, Object> usuarioMap = usuarioService.getUsuarioCliente(userEmail);                  // -> Se for Cliente
                Usuario usuario = new Usuario((int) usuarioMap.get("cd_Cliente"), (String) usuarioMap.get("cd_Cpf"),
                        (String) usuarioMap.get("nm_Cliente"), (String) usuarioMap.get("ds_Email"),
                        (String) usuarioMap.get("ds_Endereco"), (String) usuarioMap.get("ds_Cidade"), (String) usuarioMap.get("sg_Uf"),
                        (String) usuarioMap.get("cd_Cep"), (String) usuarioMap.get("cd_Telefone"),(String) usuarioMap.get("authority"));

                user = usuario;
                model.addAttribute("usuario", usuario);
            } catch (Exception e2) {                                                 // -> Se for Usuario Master
                Usuario usuario = new Usuario();
                usuario.setNm_Usuario("Master");
                user = usuario;
                model.addAttribute("usuario",usuario);

            }
        }

        return "logado.html";
    }

    // ==================== Pagina de Perfil do usuario =====================================

    @GetMapping("/perfil")
    public String perfil(Model model) {
        model.addAttribute("usuario",user);
        return "Perfil.html";
    }


    //================ Alterar Senha do Usuario =========================================

    @GetMapping("/alterarSenha")
    public String alterarSenha(Model model) {
        model.addAttribute("usuario",user);
        return "alterarSenha.html";
    }


    @PostMapping("/alterarSenha")           // -> alterar Senha do Usuario
    public String alterarSenhaPost(@ModelAttribute Usuario usuario) {
        UsuarioService usuarioService = context.getBean(UsuarioService.class);
        usuario.setAuthority(user.getAuthority());
        usuario.setCd_Usuario(user.getCd_Usuario());
        usuarioService.alterarSenha(usuario);
        return "Sucesso";
    }



    @GetMapping("/updUsuario")                                               // -> atualizar dados do usuario
    public String updateUsuario( Model model){
        model.addAttribute("antigo", user);
        model.addAttribute("usuario",new Usuario());
        return "atualizacaoUsuario";
    }

    @PostMapping("/updUsuario")
    public String updateUsuarioPost(@ModelAttribute Usuario usuario, Model model) {
        UsuarioService usuarioService = context.getBean(UsuarioService.class);
        usuario.setAuthority(user.getAuthority());
        usuario.setCd_Usuario(user.getCd_Usuario());
        usuarioService.atualizarCadastro(usuario);
        return "Sucesso";
    }






}
