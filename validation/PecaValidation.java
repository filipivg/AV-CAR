/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.validation;

/**
 *
 * @author gusta
 */
public class PecaValidation {
    
    public static void validar(String codigoNacional, String descricao, int prazoGarantia, int idFornecedor) throws Exception {
 
        GenericValidation.obrigatorio(codigoNacional, "Código Nacional");
        GenericValidation.tamanhoMinimo(codigoNacional, "Código Nacional", 2);
        GenericValidation.tamanhoMaximo(codigoNacional, "Código Nacional", 15);
 
        GenericValidation.obrigatorio(descricao, "Descrição");
        GenericValidation.tamanhoMinimo(descricao, "Descrição", 3);
        GenericValidation.tamanhoMaximo(descricao, "Descrição", 150);
 
        GenericValidation.valorMinimo(prazoGarantia, "Prazo de Garantia", 0);
 
        GenericValidation.valorMinimo(idFornecedor, "Fornecedor", 1);
    }
}
