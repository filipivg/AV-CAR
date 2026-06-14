/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.model;
/**
 *
 * @author gusta
 */
public class Peca extends BaseModelCadastro{
    
    private Fornecedor fornecedor;
    private String CodigoNacional;
    private String Descricao;
    private int PrazoGarantia;

    public Peca() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getCodigoNacional() {
        return CodigoNacional;
    }

    public void setCodigoNacional(String CodigoNacional) {
        this.CodigoNacional = CodigoNacional;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public int getPrazoGarantia() {
        return PrazoGarantia;
    }

    public void setPrazoGarantia(int PrazoGarantia) {
        this.PrazoGarantia = PrazoGarantia;
    }
    
    public Peca(int ID,boolean Ativo, Fornecedor fornecedor, String CodigoNacional, String Descricao, int PrazoGarantia){
        super(ID,Ativo);
        this.CodigoNacional = CodigoNacional;
        this.Descricao = Descricao;
        this.PrazoGarantia = PrazoGarantia;
        this.fornecedor = fornecedor;
    }
}
