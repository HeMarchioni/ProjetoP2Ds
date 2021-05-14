package com.P2Ds.model;


import lombok.Getter;
import lombok.Setter;

@Getter  // usando lombok para set e get
@Setter
public class Cliente {

    private Long id;
    private String cpf,
            nome, email, endereço,
            endComplemento,cidade,
            uf,cep, telefone, senha;





    public Cliente(Long id, String cpf, String nome, String email, String endereço, String endComplemento, String cidade, String uf, String cep, String telefone, String senha) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.endereço = endereço;
        this.endComplemento = endComplemento;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.telefone = telefone;
        this.senha = senha;
    }

    public Cliente() {

    }






}
