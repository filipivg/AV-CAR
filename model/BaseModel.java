/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.model;

/**
 *
 * @author gusta
 */
public abstract class BaseModel {
    private int ID;

    public BaseModel(){
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public BaseModel(int ID){
        this.ID = ID;
    }
}
