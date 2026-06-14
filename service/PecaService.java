/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.service;

import com.av_car_auto_center.model.Peca;
import com.av_car_auto_center.respository.PecaDao;
import com.av_car_auto_center.validation.PecaValidation;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class PecaService implements IGenericCadastroService<Peca> {
 
    private final PecaDao pecaDao;
 
    public PecaService() {
        this.pecaDao = new PecaDao();
    }

    @Override
    public List<Peca> listarAtivos() {
        return pecaDao.SelectAll();
    }

    @Override
    public void desativar(int id) {
        pecaDao.Desativar(id);
    }

    @Override
    public void ativar(int id) {
        pecaDao.Ativar(id);
    }

    @Override
    public void cadastrar(Peca peca) {
        try {
            PecaValidation.validar(
                peca.getCodigoNacional(),
                peca.getDescricao(),
                peca.getPrazoGarantia(),
                peca.getFornecedor().getID()
            );
 
            pecaDao.insert(peca);
            JOptionPane.showMessageDialog(null, "Peça cadastrada com sucesso!");
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void atualizar(Peca peca) {
        try {
            PecaValidation.validar(
                peca.getCodigoNacional(),
                peca.getDescricao(),
                peca.getPrazoGarantia(),
                peca.getFornecedor().getID()
            );
 
            pecaDao.update(peca);
            JOptionPane.showMessageDialog(null, "Peça atualizada com sucesso!");
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public Peca buscarPorID(int id) {
        return pecaDao.SelectPorID(id);
    }
    
}
