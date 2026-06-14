/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.model;

/**
 *
 * @author gusta
 */
public class ColaboradorFuncao {
    
    private Colaborador colaborador;
    private Funcao funcao;

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }
    
    public ColaboradorFuncao(Colaborador colaborador, Funcao funcao){
        this.colaborador = colaborador;
        this.funcao = funcao;
    }
}
