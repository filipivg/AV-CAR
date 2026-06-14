/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.service;

import com.av_car_auto_center.model.Servico;
import com.av_car_auto_center.respository.ServicoDao;
import com.av_car_auto_center.validation.ServicoValidation;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class ServicoService implements IGenericCadastroService<Servico> {
 
    private final ServicoDao servicoDao;
 
    public ServicoService() {
        this.servicoDao = new ServicoDao();
    }

    @Override
    public List<Servico> listarAtivos() {
        return servicoDao.SelectAll();
    }

    @Override
    public void desativar(int id) {
        servicoDao.Desativar(id);
    }

    @Override
    public void ativar(int id) {
        servicoDao.Ativar(id);
    }

    @Override
    public void cadastrar(Servico servico) {
         try {
            ServicoValidation.validar(
                servico.getDescricao(),
                servico.getPrazoGarantia(),
                servico.getTipoServico(),
                servico.getValor()
            );
 
            servicoDao.insert(servico);
            JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso!");
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void atualizar(Servico servico) {
        try {
            ServicoValidation.validar(
                servico.getDescricao(),
                servico.getPrazoGarantia(),
                servico.getTipoServico(),
                servico.getValor()
            );
 
            servicoDao.update(servico);
            JOptionPane.showMessageDialog(null, "Serviço atualizado com sucesso!");
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public Servico buscarPorID(int id) {
        return servicoDao.SelectPorID(id);
    }
 
    
}
