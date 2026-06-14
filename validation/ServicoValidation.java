/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.validation;

/**
 *
 * @author gusta
 */
public class ServicoValidation {
    
    public static void validar(String descricao, int prazoGarantia, String tipoServico, double valor) throws Exception {
 
        GenericValidation.obrigatorio(descricao, "Descrição");
        GenericValidation.tamanhoMinimo(descricao, "Descrição", 3);
        GenericValidation.tamanhoMaximo(descricao, "Descrição", 150);
 
        GenericValidation.valorMinimo(prazoGarantia, "Prazo de Garantia", 0);
 
        GenericValidation.obrigatorio(tipoServico, "Tipo de Serviço");
        GenericValidation.valoresPermitidos(tipoServico, "Tipo de Serviço", "Interno", "Terceirizado");
 
        GenericValidation.valorPositivo(valor, "Valor");
    }
}
