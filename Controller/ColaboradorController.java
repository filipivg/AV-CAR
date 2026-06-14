/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.Controller;

import com.av_car_auto_center.model.Colaborador;
import com.av_car_auto_center.model.ColaboradorFuncao;
import com.av_car_auto_center.respository.ColaboradorFuncaoDao;
import com.av_car_auto_center.service.ColaboradorService;
import java.util.List;

/**
 *
 * @author gusta
 */
public class ColaboradorController implements IGenericCadastroController<Colaborador> {
 
    private final ColaboradorService colaboradorService;
    private final ColaboradorFuncaoDao colaboradorFuncaoDao;
 
    public ColaboradorController() {
        this.colaboradorService = new ColaboradorService();
        this.colaboradorFuncaoDao = new ColaboradorFuncaoDao();
    }
 
    @Override
    public void cadastrar(Colaborador colaborador) {
        colaboradorService.cadastrar(colaborador);
    }
 
    @Override
    public void atualizar(Colaborador colaborador) {
        colaboradorService.atualizar(colaborador);
    }
 
    @Override
    public List<Colaborador> listarAtivos() {
        return colaboradorService.listarAtivos();
    }
 
    @Override
    public Colaborador buscarPorID(int id) {
        return colaboradorService.buscarPorID(id);
    }
 
    @Override
    public void desativar(int id) {
        colaboradorService.desativar(id);
    }
 
    @Override
    public void ativar(int id) {
        colaboradorService.ativar(id);
    }
    
    // ---- ColaboradorFuncao ----
 
    public void vincularFuncao(ColaboradorFuncao colaboradorFuncao) {
        colaboradorFuncaoDao.insert(colaboradorFuncao);
    }
 
    public List<ColaboradorFuncao> listarFuncoesDoColaborador(int idColaborador) {
        return colaboradorFuncaoDao.SelectPorColaborador(idColaborador);
    }
 
    public List<ColaboradorFuncao> listarColaboradoresDaFuncao(int idFuncao) {
        return colaboradorFuncaoDao.SelectPorFuncao(idFuncao);
    }
}
