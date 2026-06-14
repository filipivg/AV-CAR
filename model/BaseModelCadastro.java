package com.av_car_auto_center.model;

public abstract class BaseModelCadastro extends BaseModel{
    
    private boolean Ativo;
    
    public BaseModelCadastro() {
    }
    
    public boolean isAtivo() {
        return Ativo;
    }

    public void setAtivo(boolean Ativo) {
        this.Ativo = Ativo;
    }
    
    public BaseModelCadastro(int ID,boolean Ativo) {
        super(ID);
        this.Ativo = Ativo;
    }
}
