/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.service;

import com.av_car_auto_center.model.Fornecedor;
import com.av_car_auto_center.respository.FornecedorDao;
import com.av_car_auto_center.validation.FornecedorValidation;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class FornecedorService implements IGenericCadastroService<Fornecedor>{

    private final FornecedorDao fornecedorDao;
 
    public FornecedorService() {
        this.fornecedorDao = new FornecedorDao();
    }
    
    @Override
    public List<Fornecedor> listarAtivos() {
        return fornecedorDao.SelectAll();
    }

    @Override
    public void desativar(int id) {
        fornecedorDao.Desativar(id);
    }

    @Override
    public void ativar(int id) {
        fornecedorDao.Ativar(id);
    }

    @Override
    public void cadastrar(Fornecedor fornecedor) {
        try {
            FornecedorValidation.validar(
                fornecedor.getNomeFornecedor(),
                fornecedor.getTelefone(),
                fornecedor.getEmail()
            );
 
            fornecedorDao.insert(fornecedor);
            JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void atualizar(Fornecedor fornecedor) {
        try {
            FornecedorValidation.validar(
                fornecedor.getNomeFornecedor(),
                fornecedor.getTelefone(),
                fornecedor.getEmail()
            );
 
            fornecedorDao.update(fornecedor);
            JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso!");
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public Fornecedor buscarPorID(int id) {
        return fornecedorDao.SelectPorID(id);
    }
    
}
