package com.av_car_auto_center.model;

public class ClienteVeiculo {
    
    private Cliente cliente;
    private Veiculo veiculo;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    public ClienteVeiculo(Cliente cliente, Veiculo veiculo){
        this.cliente = cliente;
        this.veiculo = veiculo;
    }
}
