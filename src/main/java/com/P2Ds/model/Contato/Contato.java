package com.P2Ds.model.Contato;



public class Contato {

    private String nm_Contato, ds_Email, ds_Mensagem;


    public Contato() {
    }

    public Contato(String nm_Contato, String ds_Email, String ds_Mensagem) {
        this.nm_Contato = nm_Contato;
        this.ds_Email = ds_Email;
        this.ds_Mensagem = ds_Mensagem;
    }

    public String getNm_Contato() {
        return nm_Contato;
    }

    public void setNm_Contato(String nm_Contato) {
        this.nm_Contato = nm_Contato;
    }

    public String getDs_Email() {
        return ds_Email;
    }

    public void setDs_Email(String ds_Email) {
        this.ds_Email = ds_Email;
    }

    public String getDs_Mensagem() {
        return ds_Mensagem;
    }

    public void setDs_Mensagem(String ds_Mensagem) {
        this.ds_Mensagem = ds_Mensagem;
    }
}
