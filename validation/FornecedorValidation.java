/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.validation;

/**
 *
 * @author gusta
 */
public class FornecedorValidation {
    
    public static void validar(String nomeFornecedor, String telefone, String email) throws Exception {
 
        GenericValidation.obrigatorio(nomeFornecedor, "Nome do Fornecedor");
        GenericValidation.tamanhoMinimo(nomeFornecedor, "Nome do Fornecedor", 3);
        GenericValidation.tamanhoMaximo(nomeFornecedor, "Nome do Fornecedor", 100);
 
        GenericValidation.digitosEntre(telefone, "Telefone", 10, 11);
 
        GenericValidation.formatoEmail(email, "Email");
        GenericValidation.tamanhoMaximo(email, "Email", 150);
    }
}
