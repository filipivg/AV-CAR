package com.av_car_auto_center.model;

public class Colaborador extends BaseModelCadastro{
    
    private String Nome;

    public Colaborador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    public Colaborador(int ID,boolean Ativo, String Nome){
        super(ID,Ativo);
        this.Nome = Nome;
    }
}
