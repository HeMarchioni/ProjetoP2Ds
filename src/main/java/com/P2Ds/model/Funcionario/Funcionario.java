package com.P2Ds.model.Funcionario;




public class Funcionario {

    private int cd_Funcionario;
    private String cd_Cpf,nm_Funcionario,ds_Cargo,ds_Email,ds_Endereco,ds_Cidade,sg_Uf,cd_Cep,cd_Telefone,cd_Senha,authority;
    private boolean enabled;

    public Funcionario() {
    }

    public Funcionario(int cd_Funcionario, String cd_Cpf, String nm_Funcionario, String ds_Cargo, String ds_Email, String ds_Endereco, String ds_Cidade, String sg_Uf, String cd_Cep, String cd_Telefone, String cd_Senha, String authority, boolean enabled) {
        this.cd_Funcionario = cd_Funcionario;
        this.cd_Cpf = cd_Cpf;
        this.nm_Funcionario = nm_Funcionario;
        this.ds_Cargo = ds_Cargo;
        this.ds_Email = ds_Email;
        this.ds_Endereco = ds_Endereco;
        this.ds_Cidade = ds_Cidade;
        this.sg_Uf = sg_Uf;
        this.cd_Cep = cd_Cep;
        this.cd_Telefone = cd_Telefone;
        this.cd_Senha = cd_Senha;
        this.authority = authority;
        this.enabled = enabled;
    }

    public Funcionario(int cd_Funcionario, String cd_Cpf, String nm_Funcionario, String ds_Cargo, String ds_Email, String ds_Endereco, String ds_Cidade, String sg_Uf, String cd_Cep, String cd_Telefone, String authority, boolean enabled) {
        this.cd_Funcionario = cd_Funcionario;
        this.cd_Cpf = cd_Cpf;
        this.nm_Funcionario = nm_Funcionario;
        this.ds_Cargo = ds_Cargo;
        this.ds_Email = ds_Email;
        this.ds_Endereco = ds_Endereco;
        this.ds_Cidade = ds_Cidade;
        this.sg_Uf = sg_Uf;
        this.cd_Cep = cd_Cep;
        this.cd_Telefone = cd_Telefone;
        this.authority = authority;
        this.enabled = enabled;
    }




    public int getCd_Funcinario() {
        return cd_Funcionario;
    }

    public void setCd_Funcionario(int cd_Funcionario) {
        this.cd_Funcionario = cd_Funcionario;
    }

    public String getCd_Cpf() {
        return cd_Cpf;
    }

    public void setCd_Cpf(String cd_Cpf) {
        this.cd_Cpf = cd_Cpf;
    }

    public String getNm_Funcionario() {
        return nm_Funcionario;
    }

    public void setNm_Funcionario(String nm_Funcionario) {
        this.nm_Funcionario = nm_Funcionario;
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

    public String getCd_Senha() {
        return cd_Senha;
    }

    public void setCd_Senha(String cd_Senha) {
        this.cd_Senha = cd_Senha;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
