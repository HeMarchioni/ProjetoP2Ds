package com.P2Ds.model.Produto;



public class Produto {

    private long id;
    private String nm_Produto,nm_Categoria,ds_Produto;
    private double vl_Produto;

    public Produto() {
    }

    public Produto(long id, String nm_Produto, String nm_Categoria, String ds_Produto, double vl_Produto) {
        this.id = id;
        this.nm_Produto = nm_Produto;
        this.nm_Categoria = nm_Categoria;
        this.ds_Produto = ds_Produto;
        this.vl_Produto = vl_Produto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNm_Produto() {
        return nm_Produto;
    }

    public void setNm_Produto(String nm_Produto) {
        this.nm_Produto = nm_Produto;
    }

    public String getNm_Categoria() {
        return nm_Categoria;
    }

    public void setNm_Categoria(String nm_Categoria) {
        this.nm_Categoria = nm_Categoria;
    }

    public String getDs_Produto() {
        return ds_Produto;
    }

    public void setDs_Produto(String ds_Produto) {
        this.ds_Produto = ds_Produto;
    }

    public double getVl_Produto() {
        return vl_Produto;
    }

    public void setVl_Produto(double vl_Produto) {
        this.vl_Produto = vl_Produto;
    }
}
