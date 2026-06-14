/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.validation;

/**
 *
 * @author gusta
 */
public class FuncaoValidation {
    
    public static void validar(String descricao) throws Exception {
 
        GenericValidation.obrigatorio(descricao, "Descrição");
        GenericValidation.tamanhoMinimo(descricao, "Descrição", 3);
        GenericValidation.tamanhoMaximo(descricao, "Descrição", 150);
    }
}
