/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.model;

public class OrdemServicoServico{
    
    private OrdemServico ordemServico;
    private Servico servico;

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
    
    public OrdemServicoServico(OrdemServico ordemServico, Servico servico){
        this.ordemServico = ordemServico;
        this.servico = servico;
    }
}
