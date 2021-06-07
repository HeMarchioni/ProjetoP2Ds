package com.P2Ds.model.Usuario;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UsuarioService {


    @Autowired
    UsuarioDAO UserDao;




    public Map<String, Object> getUsuarioFuncionario(String userEmail) {
        return UserDao.getUsuarioFuncionario(userEmail);
    }  // -> busca do usuario

    public Map<String, Object> getUsuarioCliente(String userEmail) {
        return UserDao.getUsuarioCliente(userEmail);
    }  // -> busca do usuario


    public String getUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return  currentUserName;
        } else return null;
    }

}
