/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.validation;

/**
 *
 * @author gusta
 */
public class GenericValidation {
    
    public static void obrigatorio(String valor, String nomeCampo) throws Exception {
        if (valor == null || valor.trim().isEmpty()) {
            throw new Exception(nomeCampo + " é obrigatório.");
        }
    }
 
    public static void tamanhoMinimo(String valor, String nomeCampo, int min) throws Exception {
        if (valor != null && valor.trim().length() < min) {
            throw new Exception(nomeCampo + " deve ter pelo menos " + min + " caracteres.");
        }
    }
 
    public static void tamanhoMaximo(String valor, String nomeCampo, int max) throws Exception {
        if (valor != null && valor.trim().length() > max) {
            throw new Exception(nomeCampo + " deve ter no máximo " + max + " caracteres.");
        }
    }
 
    public static void apenasNumeros(String valor, String nomeCampo) throws Exception {
        if (valor != null && !valor.replaceAll("[^0-9]", "").equals(valor.trim())) {
            throw new Exception(nomeCampo + " deve conter apenas números.");
        }
    }
 
    public static void digitosExatos(String valor, String nomeCampo, int digitos) throws Exception {
        if (valor != null) {
            String numeros = valor.replaceAll("[^0-9]", "");
            if (numeros.length() != digitos) {
                throw new Exception(nomeCampo + " deve conter exatamente " + digitos + " dígitos numéricos.");
            }
        }
    }
 
    public static void digitosEntre(String valor, String nomeCampo, int min, int max) throws Exception {
        if (valor != null && !valor.trim().isEmpty()) {
            String numeros = valor.replaceAll("[^0-9]", "");
            if (numeros.length() < min || numeros.length() > max) {
                throw new Exception(nomeCampo + " deve conter entre " + min + " e " + max + " dígitos numéricos.");
            }
        }
    }
 
    public static void formatoEmail(String valor, String nomeCampo) throws Exception {
        if (valor != null && !valor.trim().isEmpty()) {
            if (!valor.contains("@") || !valor.contains(".")) {
                throw new Exception(nomeCampo + " inválido.");
            }
        }
    }
 
    public static void valorPositivo(double valor, String nomeCampo) throws Exception {
        if (valor <= 0) {
            throw new Exception(nomeCampo + " deve ser maior que zero.");
        }
    }
 
    public static void valorMinimo(int valor, String nomeCampo, int min) throws Exception {
        if (valor < min) {
            throw new Exception(nomeCampo + " deve ser maior ou igual a " + min + ".");
        }
    }
 
    public static void valoresPermitidos(String valor, String nomeCampo, String... permitidos) throws Exception {
        for (String permitido : permitidos) {
            if (permitido.equals(valor)) return;
        }
        String opcoes = String.join(", ", permitidos);
        throw new Exception(nomeCampo + " deve ser um dos valores: " + opcoes + ".");
    }
}
