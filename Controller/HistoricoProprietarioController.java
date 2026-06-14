/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.Controller;

import com.av_car_auto_center.model.HistoricoProprietario;
import com.av_car_auto_center.service.HistoricoProprietarioService;
import java.util.List;

/**
 *
 * @author gusta
 */
public class HistoricoProprietarioController implements IGenericController<HistoricoProprietario> {
 
    private final HistoricoProprietarioService historicoService;
 
    public HistoricoProprietarioController() {
        this.historicoService = new HistoricoProprietarioService();
    }
 
    @Override
    public void cadastrar(HistoricoProprietario historico) {
        historicoService.cadastrar(historico);
    }
 
    @Override
    public void atualizar(HistoricoProprietario historico) {
        historicoService.atualizar(historico);
    }
 
    @Override
    public HistoricoProprietario buscarPorID(int id) {
        return historicoService.buscarPorID(id);
    }
 
    public List<HistoricoProprietario> listarTodos() {
        return historicoService.listarTodos();
    }
    
}
