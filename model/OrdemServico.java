/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.model;

import java.util.Date;

/**
 *
 * @author gusta
 */
public class OrdemServico extends BaseModel{
   
    private Veiculo veiculo;
    private String NomeCliente;
    private Date DataAbertura;
    private Date DataFinalizacao;
    private double Valor;
    private String Status;

    public OrdemServico() {
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    public Date getDataAbertura() {
        return DataAbertura;
    }

    public void setDataAbertura(Date DataAbertura) {
        this.DataAbertura = DataAbertura;
    }

    public Date getDataFinalizacao() {
        return DataFinalizacao;
    }

    public void setDataFinalizacao(Date DataFinalizacao) {
        this.DataFinalizacao = DataFinalizacao;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String NomeCliente) {
        this.NomeCliente = NomeCliente;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }
    
    public OrdemServico(int ID, Veiculo veiculo,String NomeCliente, Date DataAbertura, Date DataFinalizacao,double Valor,String Status){
        super(ID);
        this.veiculo = veiculo;
        this.NomeCliente = NomeCliente;
        this.DataAbertura = DataAbertura;
        this.DataFinalizacao = DataFinalizacao;
        this.Valor = Valor;
        this.Status = Status;
    }
}
