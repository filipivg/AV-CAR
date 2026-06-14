/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.Controller;

import com.av_car_auto_center.model.Fornecedor;
import com.av_car_auto_center.service.FornecedorService;
import java.util.List;

/**
 *
 * @author gusta
 */
public class FornecedorController implements IGenericCadastroController<Fornecedor> {
 
    private final FornecedorService fornecedorService;
 
    public FornecedorController() {
        this.fornecedorService = new FornecedorService();
    }
 
    @Override
    public void cadastrar(Fornecedor fornecedor) {
        fornecedorService.cadastrar(fornecedor);
    }
 
    @Override
    public void atualizar(Fornecedor fornecedor) {
        fornecedorService.atualizar(fornecedor);
    }
 
    @Override
    public List<Fornecedor> listarAtivos() {
        return fornecedorService.listarAtivos();
    }
 
    @Override
    public Fornecedor buscarPorID(int id) {
        return fornecedorService.buscarPorID(id);
    }
 
    @Override
    public void desativar(int id) {
        fornecedorService.desativar(id);
    }
 
    @Override
    public void ativar(int id) {
        fornecedorService.ativar(id);
    }
    
}
