package com.P2Ds.model.Fornecedor;

public class Fornecedor {

    private int cd_Fornecedor;
    private String nm_Fornecedor
    ,nm_Produto
    ,ds_Fornecedor
    ,nm_Contato
    ,cd_Telefone
    ,ds_Email;


    public Fornecedor() {
    }


    public Fornecedor(int cd_Fornecedor, String nm_Fornecedor, String nm_Produto, String ds_Fornecedor, String nm_Contato, String cd_Telefone, String ds_Email) {
        this.cd_Fornecedor = cd_Fornecedor;
        this.nm_Fornecedor = nm_Fornecedor;
        this.nm_Produto = nm_Produto;
        this.ds_Fornecedor = ds_Fornecedor;
        this.nm_Contato = nm_Contato;
        this.cd_Telefone = cd_Telefone;
        this.ds_Email = ds_Email;
    }


    public int getCd_Fornecedor() {
        return cd_Fornecedor;
    }

    public void setCd_Fornecedor(int cd_Fornecedor) {
        this.cd_Fornecedor = cd_Fornecedor;
    }

    public String getNm_Fornecedor() {
        return nm_Fornecedor;
    }

    public void setNm_Fornecedor(String nm_Fornecedor) {
        this.nm_Fornecedor = nm_Fornecedor;
    }

    public String getNm_Produto() {
        return nm_Produto;
    }

    public void setNm_Produto(String nm_Produto) {
        this.nm_Produto = nm_Produto;
    }

    public String getDs_Fornecedor() {
        return ds_Fornecedor;
    }

    public void setDs_Fornecedor(String ds_Fornecedor) {
        this.ds_Fornecedor = ds_Fornecedor;
    }

    public String getNm_Contato() {
        return nm_Contato;
    }

    public void setNm_Contato(String nm_Contato) {
        this.nm_Contato = nm_Contato;
    }

    public String getCd_Telefone() {
        return cd_Telefone;
    }

    public void setCd_Telefone(String cd_Telefone) {
        this.cd_Telefone = cd_Telefone;
    }

    public String getDs_Email() {
        return ds_Email;
    }

    public void setDs_Email(String ds_Email) {
        this.ds_Email = ds_Email;
    }
}
