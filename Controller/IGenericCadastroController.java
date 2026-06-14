/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av_car_auto_center.Controller;

import java.util.List;

/**
 *
 * @author gusta
 * @param <T>
 */
public interface IGenericCadastroController<T> extends IGenericController<T> {
    List<T> listarAtivos();
    void desativar(int id);
    void ativar(int id);
    
}
