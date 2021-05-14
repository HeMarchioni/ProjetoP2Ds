package com.P2Ds.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteDAO cdao;


    public void inserirCliente(Cliente c) {
        cdao.inserirCliente(c);
    }

}
