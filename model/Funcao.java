/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.model;

/**
 *
 * @author gusta
 */
public class Funcao extends BaseModelCadastro{

    private String Descricao;

    public Funcao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
    
    public Funcao(int ID, boolean Ativo, String Descricao){
        super(ID,Ativo);
        this.Descricao = Descricao;
    }
}
