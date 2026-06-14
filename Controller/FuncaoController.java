/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.Controller;

import com.av_car_auto_center.model.Funcao;
import com.av_car_auto_center.service.FuncaoService;
import java.util.List;

/**
 *
 * @author gusta
 */
public class FuncaoController implements IGenericCadastroController<Funcao> {
 
    private final FuncaoService funcaoService;
 
    public FuncaoController() {
        this.funcaoService = new FuncaoService();
    }
 
    @Override
    public void cadastrar(Funcao funcao) {
        funcaoService.cadastrar(funcao);
    }
 
    @Override
    public void atualizar(Funcao funcao) {
        funcaoService.atualizar(funcao);
    }
 
    @Override
    public List<Funcao> listarAtivos() {
        return funcaoService.listarAtivos();
    }
 
    @Override
    public Funcao buscarPorID(int id) {
        return funcaoService.buscarPorID(id);
    }
 
    @Override
    public void desativar(int id) {
        funcaoService.desativar(id);
    }
 
    @Override
    public void ativar(int id) {
        funcaoService.ativar(id);
    }
    
}
