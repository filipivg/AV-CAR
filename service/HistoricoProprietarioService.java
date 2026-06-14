/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.service;

import com.av_car_auto_center.model.HistoricoProprietario;
import com.av_car_auto_center.respository.HistoricoProprietarioDao;
import com.av_car_auto_center.validation.HistoricoProprietarioValidation;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class HistoricoProprietarioService implements IGenericService<HistoricoProprietario>{

    private final HistoricoProprietarioDao historicoDao;
 
    public HistoricoProprietarioService() {
        this.historicoDao = new HistoricoProprietarioDao();
    }
 
    @Override
    public void cadastrar(HistoricoProprietario historico) {
        try {
            HistoricoProprietarioValidation.validar(
                historico.getDataInicio(),
                historico.getDataFim(),
                historico.getVeiculo().getID(),
                historico.getCliente().getID()
            );
 
            historicoDao.insert(historico);
            JOptionPane.showMessageDialog(null, "Histórico cadastrado com sucesso!");
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
 
    @Override
    public void atualizar(HistoricoProprietario historico) {
        try {
            HistoricoProprietarioValidation.validar(
                historico.getDataInicio(),
                historico.getDataFim(),
                historico.getVeiculo().getID(),
                historico.getCliente().getID()
            );
 
            historicoDao.update(historico);
            JOptionPane.showMessageDialog(null, "Histórico atualizado com sucesso!");
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
 
    @Override
    public HistoricoProprietario buscarPorID(int id) {
        return historicoDao.SelectPorID(id);
    }
 
    public List<HistoricoProprietario> listarTodos() {
        return historicoDao.SelectAll();
    }
}
