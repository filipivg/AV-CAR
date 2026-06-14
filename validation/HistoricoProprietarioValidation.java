/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.validation;

import java.util.Date;

/**
 *
 * @author gusta
 */
public class HistoricoProprietarioValidation {
    
    public static void validar(Date dataInicio, Date dataFim, int idVeiculo, int idCliente) throws Exception {
 
        if (dataInicio == null) {
            throw new Exception("Data de Início é obrigatória.");
        }
 
        if (dataFim != null && dataFim.before(dataInicio)) {
            throw new Exception("Data de Fim não pode ser anterior à Data de Início.");
        }
 
        GenericValidation.valorMinimo(idVeiculo, "Veículo", 1);
        GenericValidation.valorMinimo(idCliente, "Cliente", 1);
    }
}
