package com.P2Ds.model;



import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


public class Cliente {

    private Long id;
    private String cd_Cpf,nm_Cliente,ds_Email,ds_Endereco,ds_Cidade,sg_Uf,cd_Cep,cd_Telefone,cd_Senha;


    public Cliente() {

    }


    public Cliente(Long id, String cd_Cpf, String nm_Cliente, String ds_Email, String ds_Endereco, String ds_Cidade, String sg_Uf, String cd_Cep, String cd_Telefone, String cd_Senha) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        this.id = id;
        this.cd_Cpf = cd_Cpf;
        this.nm_Cliente = nm_Cliente;
        this.ds_Email = ds_Email;
        this.ds_Endereco = ds_Endereco;
        this.ds_Cidade = ds_Cidade;
        this.sg_Uf = sg_Uf;
        this.cd_Cep = cd_Cep;
        this.cd_Telefone = cd_Telefone;
        this.cd_Senha = cd_Senha;
    }

    protected String hashSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        return hexString.toString();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
