/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.Controller;

import com.av_car_auto_center.model.Pagamento;
import com.av_car_auto_center.service.PagamentoService;
import java.util.List;

/**
 *
 * @author gusta
 */
public class PagamentoController implements IGenericController<Pagamento> {
 
    private final PagamentoService pagamentoService;
 
    public PagamentoController() {
        this.pagamentoService = new PagamentoService();
    }
 
    @Override
    public void cadastrar(Pagamento pagamento) {
        pagamentoService.cadastrar(pagamento);
    }
 
    @Override
    public void atualizar(Pagamento pagamento) {
        pagamentoService.atualizar(pagamento);
    }
 
    @Override
    public Pagamento buscarPorID(int id) {
        return pagamentoService.buscarPorID(id);
    }
 
    public List<Pagamento> listarTodos() {
        return pagamentoService.listarTodos();
    }
}
