/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.model;

/**
 *
 * @author gusta
 */
public class Fornecedor extends BaseModelCadastro{
    
    private String NomeFornecedor;
    private String Telefone;
    private String Email;

    public Fornecedor() {
    }

    public String getNomeFornecedor() {
        return NomeFornecedor;
    }

    public void setNomeFornecedor(String NomeFornecedor) {
        this.NomeFornecedor = NomeFornecedor;
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

    public Fornecedor(int ID,boolean Ativo, String NomeFornecedor, String Telefone, String Email){
        super(ID,Ativo);
        this.NomeFornecedor = NomeFornecedor;
        this.Telefone = Telefone;
        this.Email = Email;
    }
}
