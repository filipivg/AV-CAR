/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.model;

/**
 *
 * @author gusta
 */
public class Veiculo extends BaseModelCadastro{
    
    private String Placa;
    private String Marca;
    private String Modelo;
    private int AnoFabricacao;
    private int AnoModelo;

    public Veiculo() {
    }


    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public int getAnoFabricacao() {
        return AnoFabricacao;
    }

    public void setAnoFabricacao(int AnoFabricacao) {
        this.AnoFabricacao = AnoFabricacao;
    }

    public int getAnoModelo() {
        return AnoModelo;
    }

    public void setAnoModelo(int AnoModelo) {
        this.AnoModelo = AnoModelo;
    }
    
    public Veiculo(int ID, boolean Ativo, String Placa, String Marca, String Modelo, int AnoFabricacao, int AnoModelo){
        super(ID,Ativo);
        this.Placa = Placa;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.AnoFabricacao = AnoFabricacao;
        this.AnoModelo = AnoModelo;
    }
}
