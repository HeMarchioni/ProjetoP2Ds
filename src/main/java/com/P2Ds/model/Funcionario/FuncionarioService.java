package com.P2Ds.model.Funcionario;



import com.P2Ds.model.Fornecedor.Fornecedor;
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


    public void deleteFuncionario(int cd_Funcionario) {
        funciDao.deleteFuncionario(cd_Funcionario);
    }  // -> apagar produto no banco de dados


    public Map<String, Object> getCd_Funcionario(int cd_Funcionario) {
        return funciDao.getCd_Funcionario(cd_Funcionario);
    }  // -> busca somente pelo codigo


    public void updateFuncionario(int cd_Funcionario, Funcionario funcionario) {
        funciDao.updateFuncionario(cd_Funcionario, funcionario);
    } // -> atualizar dados do fornecedor no banco




}
