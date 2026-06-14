/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.validation;

/**
 *
 * @author gusta
 */
public class ColaboradorValidation {
    
    public static void validar(String nomeColaborador) throws Exception {
 
        GenericValidation.obrigatorio(nomeColaborador, "Nome do Colaborador");
        GenericValidation.tamanhoMinimo(nomeColaborador, "Nome do Colaborador", 3);
        GenericValidation.tamanhoMaximo(nomeColaborador, "Nome do Colaborador", 100);
    }
}
