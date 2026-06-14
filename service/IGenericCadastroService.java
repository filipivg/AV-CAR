/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av_car_auto_center.service;

import java.util.List;

/**
 *
 * @author gusta
 */
public interface IGenericCadastroService <T> extends IGenericService<T> {
    
    List<T> listarAtivos();
    void desativar(int id);
    void ativar(int id);
}
