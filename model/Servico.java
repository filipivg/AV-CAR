/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.model;

/**
 *
 * @author gusta
 */
public class Servico extends BaseModelCadastro{
    
    private String Descricao;
    private int PrazoGarantia;
    private String TipoServico;
    private double Valor;

    public Servico() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public String getTipoServico() {
        return TipoServico;
    }

    public void setTipoServico(String TipoServico) {
        this.TipoServico = TipoServico;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }
    
    public Servico(int ID,boolean Ativo, String Descricao, int PrazoGarantia, String TipoServico, double Valor){
        super(ID,Ativo);
        this.Descricao = Descricao;
        this.PrazoGarantia = PrazoGarantia;
        this.TipoServico = TipoServico;
        this.Valor = Valor;
    }
}
