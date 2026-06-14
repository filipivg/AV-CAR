/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.service;

import com.av_car_auto_center.model.Colaborador;
import com.av_car_auto_center.respository.ColaboradorDao;
import com.av_car_auto_center.validation.ColaboradorValidation;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class ColaboradorService implements IGenericCadastroService<Colaborador> {
 
    private final ColaboradorDao colaboradorDao;
 
    public ColaboradorService() {
        this.colaboradorDao = new ColaboradorDao();
    }

    @Override
    public List<Colaborador> listarAtivos() {
        return colaboradorDao.SelectAll();
    }

    @Override
    public void desativar(int id) {
        colaboradorDao.Desativar(id);
    }

    @Override
    public void ativar(int id) {
        colaboradorDao.Ativar(id);
    }

    @Override
    public void cadastrar(Colaborador colaborador) {
        try {
            ColaboradorValidation.validar(colaborador.getNome());
 
            colaboradorDao.insert(colaborador);
            JOptionPane.showMessageDialog(null, "Colaborador cadastrado com sucesso!");
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void atualizar(Colaborador colaborador) {
        try {
            ColaboradorValidation.validar(colaborador.getNome());
 
            colaboradorDao.update(colaborador);
            JOptionPane.showMessageDialog(null, "Colaborador atualizado com sucesso!");
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public Colaborador buscarPorID(int id) {
        return colaboradorDao.SelectPorID(id);
    }
    
}
