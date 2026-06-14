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
public class OrdemServicoValidation {
    
    public static void validar(String nomeCliente, Date dataAbertura, Date dataFinalizacao, double valor, String status, int idVeiculo) throws Exception {
 
        GenericValidation.obrigatorio(nomeCliente, "Nome do Cliente");
        GenericValidation.tamanhoMinimo(nomeCliente, "Nome do Cliente", 3);
        GenericValidation.tamanhoMaximo(nomeCliente, "Nome do Cliente", 100);
 
        if (dataAbertura == null) {
            throw new Exception("Data de Abertura é obrigatória.");
        }
 
        if (dataFinalizacao != null && dataFinalizacao.before(dataAbertura)) {
            throw new Exception("Data de Finalização não pode ser anterior à Data de Abertura.");
        }
 
        GenericValidation.valorPositivo(valor, "Valor");
 
        GenericValidation.obrigatorio(status, "Status");
        GenericValidation.valoresPermitidos(status, "Status", "Pendente", "Execução", "Aguardando Pagamento", "Finalizada");
 
        GenericValidation.valorMinimo(idVeiculo, "Veículo", 1);
    }
}
