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
public class Pagamento extends BaseModel{
    
    private Date DataPagamento;
    private double Valor;

    public Date getDataPagamento() {
        return DataPagamento;
    }

    public void setDataPagamento(Date DataPagamento) {
        this.DataPagamento = DataPagamento;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }
    
    public Pagamento(int ID, Date DataPagamento, double Valor){
        super(ID);
        this.DataPagamento = DataPagamento;
        this.Valor = Valor;
    }
}
