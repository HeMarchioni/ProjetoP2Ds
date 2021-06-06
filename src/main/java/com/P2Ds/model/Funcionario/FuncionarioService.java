package com.P2Ds.model.Funcionario;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioDAO funciDao;


    public void inserirFuncionario(Funcionario funci) {
        funciDao.inserirFuncionario(funci);
    }


    public List<Map<String, Object>> getListaFuncionarios() {
        return funciDao.getListaFuncionarios();
    }  // -> pega a lista de todos os funcionarios cadastrados



}
