package com.P2Ds.model.Usuario;




public class Usuario {


    private int cd_Usuario;
    private String cd_Cpf,nm_Usuario,ds_Cargo,ds_Email,ds_Endereco,ds_Cidade,sg_Uf,cd_Cep,cd_Telefone,cd_Senha,authority;



    public Usuario() {
    }

    public Usuario(int cd_Usuario, String cd_Cpf, String nm_Usuario, String ds_Email, String ds_Endereco, String ds_Cidade, String sg_Uf, String cd_Cep, String cd_Telefone, String authority) {
        this.cd_Usuario = cd_Usuario;
        this.cd_Cpf = cd_Cpf;
        this.nm_Usuario = nm_Usuario;
        this.ds_Email = ds_Email;
        this.ds_Endereco = ds_Endereco;
        this.ds_Cidade = ds_Cidade;
        this.sg_Uf = sg_Uf;
        this.cd_Cep = cd_Cep;
        this.cd_Telefone = cd_Telefone;
        this.authority = authority;
    }

    public Usuario(int cd_Usuario, String cd_Cpf, String nm_Usuario, String ds_Cargo, String ds_Email, String ds_Endereco, String ds_Cidade, String sg_Uf, String cd_Cep, String cd_Telefone,String authority) {
        this.cd_Usuario = cd_Usuario;
        this.cd_Cpf = cd_Cpf;
        this.nm_Usuario = nm_Usuario;
        this.ds_Cargo = ds_Cargo;
        this.ds_Email = ds_Email;
        this.ds_Endereco = ds_Endereco;
        this.ds_Cidade = ds_Cidade;
        this.sg_Uf = sg_Uf;
        this.cd_Cep = cd_Cep;
        this.cd_Telefone = cd_Telefone;
        this.authority = authority;
    }


    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getCd_Senha() {
        return cd_Senha;
    }

    public void setCd_Senha(String cd_Senha) {
        this.cd_Senha = cd_Senha;
    }

    public int getCd_Usuario() {
        return cd_Usuario;
    }

    public void setCd_Usuario(int cd_Usuario) {
        this.cd_Usuario = cd_Usuario;
    }

    public String getCd_Cpf() {
        return cd_Cpf;
    }

    public void setCd_Cpf(String cd_Cpf) {
        this.cd_Cpf = cd_Cpf;
    }

    public String getNm_Usuario() {
        return nm_Usuario;
    }

    public void setNm_Usuario(String nm_Usuario) {
        this.nm_Usuario = nm_Usuario;
    }

    public String getDs_Cargo() {
        return ds_Cargo;
    }

    public void setDs_Cargo(String ds_Cargo) {
        this.ds_Cargo = ds_Cargo;
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
}
