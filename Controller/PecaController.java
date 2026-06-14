/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.Controller;

import com.av_car_auto_center.model.Peca;
import com.av_car_auto_center.service.PecaService;
import java.util.List;

/**
 *
 * @author gusta
 */
public class PecaController implements IGenericCadastroController<Peca> {
 
    private final PecaService pecaService;
 
    public PecaController() {
        this.pecaService = new PecaService();
    }
 
    @Override
    public void cadastrar(Peca peca) {
        pecaService.cadastrar(peca);
    }
 
    @Override
    public void atualizar(Peca peca) {
        pecaService.atualizar(peca);
    }
 
    @Override
    public List<Peca> listarAtivos() {
        return pecaService.listarAtivos();
    }
 
    @Override
    public Peca buscarPorID(int id) {
        return pecaService.buscarPorID(id);
    }
 
    @Override
    public void desativar(int id) {
        pecaService.desativar(id);
    }
 
    @Override
    public void ativar(int id) {
        pecaService.ativar(id);
    }
    
}
