/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av_car_auto_center.respository;

/**
 *
 * @author gusta
 * @param <T>
 */
public interface DaoCadastro<T> extends GenericDao<T> {

    void Desativar(int id);
    void Ativar(int id);
}
