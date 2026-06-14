/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.model;

/**
 *
 * @author gusta
 */
public class OrdemServicoPeca{
    
    private OrdemServico ordemServico;
    private Peca peca;

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }
    
    public OrdemServicoPeca(OrdemServico ordemServico, Peca peca){
        this.ordemServico = ordemServico;
        this.peca = peca;
    }
}
