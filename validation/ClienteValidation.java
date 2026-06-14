/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.validation;

/**
 *
 * @author gusta
 */
public class ClienteValidation {
    
    public static void validar(String tipoCliente, String nomeRazaoSocial, String cpf, String telefone, String email) throws Exception {
 
        GenericValidation.obrigatorio(tipoCliente, "Tipo de Cliente");
        GenericValidation.valoresPermitidos(tipoCliente, "Tipo de Cliente", "Físico", "Jurídico");
 
        GenericValidation.obrigatorio(nomeRazaoSocial, "Nome / Razão Social");
        GenericValidation.tamanhoMinimo(nomeRazaoSocial, "Nome / Razão Social", 3);
        GenericValidation.tamanhoMaximo(nomeRazaoSocial, "Nome / Razão Social", 100);
 
        GenericValidation.obrigatorio(cpf, "CPF");
        GenericValidation.digitosExatos(cpf, "CPF", 11);
 
        GenericValidation.digitosEntre(telefone, "Telefone", 10, 11);
 
        GenericValidation.formatoEmail(email, "Email");
        GenericValidation.tamanhoMaximo(email, "Email", 150);
    }
}
