/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.Controller;

import com.av_car_auto_center.model.Servico;
import com.av_car_auto_center.service.ServicoService;
import java.util.List;

/**
 *
 * @author gusta
 */
public class ServicoController implements IGenericCadastroController<Servico> {
 
    private final ServicoService servicoService;
 
    public ServicoController() {
        this.servicoService = new ServicoService();
    }
 
    @Override
    public void cadastrar(Servico servico) {
        servicoService.cadastrar(servico);
    }
 
    @Override
    public void atualizar(Servico servico) {
        servicoService.atualizar(servico);
    }
 
    @Override
    public List<Servico> listarAtivos() {
        return servicoService.listarAtivos();
    }
 
    @Override
    public Servico buscarPorID(int id) {
        return servicoService.buscarPorID(id);
    }
 
    @Override
    public void desativar(int id) {
        servicoService.desativar(id);
    }
 
    @Override
    public void ativar(int id) {
        servicoService.ativar(id);
    }
    
}
