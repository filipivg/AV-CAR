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
public class PagamentoValidation {
    
    public static void validar(Date dataPagamento, double valor) throws Exception {
 
        if (dataPagamento == null) {
            throw new Exception("Data de Pagamento é obrigatória.");
        }
 
        GenericValidation.valorPositivo(valor, "Valor");
    }
}
