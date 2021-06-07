package com.P2Ds.model.Cliente;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteDAO cdao;


    public void inserirCliente(Cliente c) {
        cdao.inserirCliente(c);
    }


    public boolean verificaEmail(String ds_Email){
        try {
            cdao.verificaEmail(ds_Email).get("ds_Email");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean verificaEmail2(String ds_Email) {
        try {
            cdao.verificaEmail2(ds_Email).get("ds_Email");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
