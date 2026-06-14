/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.Controller;

import com.av_car_auto_center.model.Veiculo;
import com.av_car_auto_center.service.VeiculoService;
import java.util.List;

/**
 *
 * @author gusta
 */
public class VeiculoController implements IGenericCadastroController<Veiculo> {
 
    private final VeiculoService veiculoService;
 
    public VeiculoController() {
        this.veiculoService = new VeiculoService();
    }
 
    @Override
    public void cadastrar(Veiculo veiculo) {
        veiculoService.cadastrar(veiculo);
    }
 
    @Override
    public void atualizar(Veiculo veiculo) {
        veiculoService.atualizar(veiculo);
    }
 
    @Override
    public List<Veiculo> listarAtivos() {
        return veiculoService.listarAtivos();
    }
 
    @Override
    public Veiculo buscarPorID(int id) {
        return veiculoService.buscarPorID(id);
    }
 
    @Override
    public void desativar(int id) {
        veiculoService.desativar(id);
    }
 
    @Override
    public void ativar(int id) {
        veiculoService.ativar(id);
    }
    
}
