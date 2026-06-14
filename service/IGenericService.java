/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av_car_auto_center.service;

/**
 *
 * @author gusta
 * @param <T>
 */
public interface IGenericService <T> {
    
    void cadastrar(T obj);
    void atualizar(T obj);
    T buscarPorID(int id);
}
