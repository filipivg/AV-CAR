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
public class HistoricoProprietario extends BaseModel {
   
    private Date DataInicio;
    private Date DataFim;
    private Veiculo veiculo;
    private Cliente cliente;

    public Date getDataInicio() {
        return DataInicio;
    }

    public void setDataInicio(Date DataInicio) {
        this.DataInicio = DataInicio;
    }

    public Date getDataFim() {
        return DataFim;
    }

    public void setDataFim(Date DataFim) {
        this.DataFim = DataFim;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public HistoricoProprietario(int ID, Date DataInicio, Date DataFim, Veiculo veiculo, Cliente cliente){
        super(ID);
        this.DataInicio = DataInicio;
        this.DataFim = DataFim;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }
}
