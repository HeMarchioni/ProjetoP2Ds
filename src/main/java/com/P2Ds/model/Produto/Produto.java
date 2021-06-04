package com.P2Ds.model.Produto;



public class Produto {

    private long cd_Produto;
    private String nm_Produto,nm_Genero,nm_Categoria,ds_Produto,nm_Marca,nm_Cor,ds_Tamanho;
    private double vl_Produto;

    public Produto() {
    }


    public Produto(long cd_Produto, String nm_Produto,String nm_Genero, String nm_Categoria, String ds_Produto, String nm_Marca, String nm_Cor, String ds_Tamanho, double vl_Produto) {
        this.cd_Produto = cd_Produto;
        this.nm_Produto = nm_Produto;
        this.nm_Genero = nm_Genero;
        this.nm_Categoria = nm_Categoria;
        this.ds_Produto = ds_Produto;
        this.nm_Marca = nm_Marca;
        this.nm_Cor = nm_Cor;
        this.ds_Tamanho = ds_Tamanho;
        this.vl_Produto = vl_Produto;
    }


    public String getNm_Genero() {
        return nm_Genero;
    }

    public void setNm_Genero(String nm_Genero) {
        this.nm_Genero = nm_Genero;
    }

    public String getNm_Marca() {
        return nm_Marca;
    }

    public void setNm_Marca(String nm_Marca) {
        this.nm_Marca = nm_Marca;
    }

    public String getNm_Cor() {
        return nm_Cor;
    }

    public void setNm_Cor(String nm_Cor) {
        this.nm_Cor = nm_Cor;
    }

    public String getDs_Tamanho() {
        return ds_Tamanho;
    }

    public void setDs_Tamanho(String ds_Tamanho) {
        this.ds_Tamanho = ds_Tamanho;
    }

    public long getCd_Produto() {
        return cd_Produto;
    }

    public void setCd_Produto(long cd_Produto) {
        this.cd_Produto = cd_Produto;
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
