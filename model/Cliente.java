/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.model;

/**
 *
 * @author gusta
 */
public class Cliente extends BaseModelCadastro{
    
    private String TipoCliente;
    private String NomeRazaoSocial;
    private String CPF;
    private String Telefone;
    private String Email;

    public Cliente(){
    }    
    
    public String getTipoCliente() {
        return TipoCliente;
    }

    public void setTipoCliente(String TipoCliente) {
        this.TipoCliente = TipoCliente;
    }

    public String getNomeRazaoSocial() {
        return NomeRazaoSocial;
    }

    public void setNomeRazaoSocial(String NomeRazaoSocial) {
        this.NomeRazaoSocial = NomeRazaoSocial;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public Cliente(int ID, boolean Ativo, String TipoCliente, String NomeRazaoSocial, String CPF, String Telefone, String Email){
        super(ID,Ativo);
        this.TipoCliente = TipoCliente;
        this.NomeRazaoSocial = NomeRazaoSocial;
        this.CPF = CPF;
        this.Telefone = Telefone;
        this.Email = Email;
    }
}
