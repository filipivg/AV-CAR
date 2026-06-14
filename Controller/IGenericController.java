/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av_car_auto_center.Controller;

/**
 *
 * @author gusta
 * @param <T>
 */
public interface IGenericController<T> {
    void cadastrar(T obj);
    void atualizar(T obj);
    T buscarPorID(int id);
    
}
