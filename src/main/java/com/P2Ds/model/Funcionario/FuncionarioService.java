package com.P2Ds.model.Funcionario;


import com.P2Ds.model.Cliente.Cliente;
import com.P2Ds.model.Cliente.ClienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioDAO funciDao;


    public void inserirFuncionario(Funcionario funci) {
        funciDao.inserirFuncionario(funci);
    }


}
