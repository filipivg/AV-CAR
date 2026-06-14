/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.service;

import com.av_car_auto_center.model.Funcao;
import com.av_car_auto_center.respository.FuncaoDao;
import com.av_car_auto_center.validation.FuncaoValidation;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class FuncaoService implements IGenericCadastroService<Funcao> {
 
    private final FuncaoDao funcaoDao;
 
    public FuncaoService() {
        this.funcaoDao = new FuncaoDao();
    }

    @Override
    public List<Funcao> listarAtivos() {
        return funcaoDao.SelectAll();
    }

    @Override
    public void desativar(int id) {
        funcaoDao.Desativar(id);
    }

    @Override
    public void ativar(int id) {
        funcaoDao.Ativar(id);
    }

    @Override
    public void cadastrar(Funcao funcao) {
        try {
            FuncaoValidation.validar(funcao.getDescricao());
 
            funcaoDao.insert(funcao);
            JOptionPane.showMessageDialog(null, "Função cadastrada com sucesso!");
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void atualizar(Funcao funcao) {
        try {
            FuncaoValidation.validar(funcao.getDescricao());
 
            funcaoDao.update(funcao);
            JOptionPane.showMessageDialog(null, "Função atualizada com sucesso!");
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public Funcao buscarPorID(int id) {
        return funcaoDao.SelectPorID(id);
    }
    
}
