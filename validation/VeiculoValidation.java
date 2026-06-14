/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.validation;

/**
 *
 * @author gusta
 */
public class VeiculoValidation {
    
    public static void validar(String placa, String marca, String modelo, int anoFabricacao, int anoModelo) throws Exception {
 
        GenericValidation.obrigatorio(placa, "Placa");
        GenericValidation.digitosExatos(placa.replaceAll("[^a-zA-Z0-9]", ""), "Placa", 7);
 
        GenericValidation.obrigatorio(marca, "Marca");
        GenericValidation.tamanhoMinimo(marca, "Marca", 2);
        GenericValidation.tamanhoMaximo(marca, "Marca", 50);
 
        GenericValidation.obrigatorio(modelo, "Modelo");
        GenericValidation.tamanhoMinimo(modelo, "Modelo", 2);
        GenericValidation.tamanhoMaximo(modelo, "Modelo", 50);
 
        GenericValidation.valorMinimo(anoFabricacao, "Ano de Fabricação", 1900);
        GenericValidation.valorMinimo(anoModelo, "Ano do Modelo", 1900);
 
        if (anoModelo < anoFabricacao) {
            throw new Exception("Ano do Modelo não pode ser menor que o Ano de Fabricação.");
        }
    }
}

