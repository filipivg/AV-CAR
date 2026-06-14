/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.service;

import com.av_car_auto_center.model.Pagamento;
import com.av_car_auto_center.respository.PagamentoDao;
import com.av_car_auto_center.validation.PagamentoValidation;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class PagamentoService implements IGenericService<Pagamento> {
 
    private final PagamentoDao pagamentoDao;
 
    public PagamentoService() {
        this.pagamentoDao = new PagamentoDao();
    }

    @Override
    public void cadastrar(Pagamento pagamento) {
        try {
            PagamentoValidation.validar(
                pagamento.getDataPagamento(),
                pagamento.getValor()
            );
 
            pagamentoDao.insert(pagamento);
            JOptionPane.showMessageDialog(null, "Pagamento cadastrado com sucesso!");
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
 
    @Override
    public void atualizar(Pagamento pagamento) {
        try {
            PagamentoValidation.validar(
                pagamento.getDataPagamento(),
                pagamento.getValor()
            );
 
            pagamentoDao.update(pagamento);
            JOptionPane.showMessageDialog(null, "Pagamento atualizado com sucesso!");
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
 
    @Override
    public Pagamento buscarPorID(int id) {
        return pagamentoDao.SelectPorID(id);
    }
 
    public List<Pagamento> listarTodos() {
        return pagamentoDao.SelectAll();
    }
    
}
