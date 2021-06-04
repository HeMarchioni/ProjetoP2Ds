package com.P2Ds.model.Cliente;



import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;



public class Cliente {

    private Long cd_Cliente;
    private String cd_Cpf,nm_Cliente,ds_Email,ds_Endereco,ds_Cidade,sg_Uf,cd_Cep,cd_Telefone,cd_Senha;
    private boolean enabled;


    public Cliente() {

    }


    public Cliente(Long cd_Cliente, String cd_Cpf, String nm_Cliente, String ds_Email, String ds_Endereco, String ds_Cidade, String sg_Uf, String cd_Cep, String cd_Telefone, String cd_Senha, boolean enabled) {
        this.cd_Cliente = cd_Cliente;
        this.cd_Cpf = cd_Cpf;
        this.nm_Cliente = nm_Cliente;
        this.ds_Email = ds_Email;
        this.ds_Endereco = ds_Endereco;
        this.ds_Cidade = ds_Cidade;
        this.sg_Uf = sg_Uf;
        this.cd_Cep = cd_Cep;
        this.cd_Telefone = cd_Telefone;
        this.cd_Senha = cd_Senha;
        this.enabled = enabled;
    }




    public Long getCd_Cliente() {
        return cd_Cliente;
    }

    public void setCd_Cliente(Long cd_Cliente) {
        this.cd_Cliente = cd_Cliente;
    }

    public String getCd_Cpf() {
        return cd_Cpf;
    }

    public void setCd_Cpf(String cd_Cpf) {
        this.cd_Cpf = cd_Cpf;
    }

    public String getNm_Cliente() {
        return nm_Cliente;
    }

    public void setNm_Cliente(String nm_Cliente) {
        this.nm_Cliente = nm_Cliente;
    }

    public String getDs_Email() {
        return ds_Email;
    }

    public void setDs_Email(String ds_Email) {
        this.ds_Email = ds_Email;
    }

    public String getDs_Endereco() {
        return ds_Endereco;
    }

    public void setDs_Endereco(String ds_Endereco) {
        this.ds_Endereco = ds_Endereco;
    }

    public String getDs_Cidade() {
        return ds_Cidade;
    }

    public void setDs_Cidade(String ds_Cidade) {
        this.ds_Cidade = ds_Cidade;
    }

    public String getSg_Uf() {
        return sg_Uf;
    }

    public void setSg_Uf(String sg_Uf) {
        this.sg_Uf = sg_Uf;
    }

    public String getCd_Cep() {
        return cd_Cep;
    }

    public void setCd_Cep(String cd_Cep) {
        this.cd_Cep = cd_Cep;
    }

    public String getCd_Telefone() {
        return cd_Telefone;
    }

    public void setCd_Telefone(String cd_Telefone) {
        this.cd_Telefone = cd_Telefone;
    }

    public String getCd_Senha() {
        return cd_Senha;
    }

    public void setCd_Senha(String cd_Senha) {
        this.cd_Senha = cd_Senha;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
