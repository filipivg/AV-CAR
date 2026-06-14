/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.service;

import com.av_car_auto_center.model.OrdemServico;
import com.av_car_auto_center.model.Veiculo;
import com.av_car_auto_center.respository.OrdemServicoDao;
import com.av_car_auto_center.respository.VeiculoDao;
import com.av_car_auto_center.validation.VeiculoValidation;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class VeiculoService implements IGenericCadastroService<Veiculo>{

    private final VeiculoDao veiculoDao;
    private final OrdemServicoDao ordemServicoDao;
    
    public VeiculoService() {
        this.veiculoDao = new VeiculoDao();
        this.ordemServicoDao = new OrdemServicoDao();
    }
    
    @Override
    public List<Veiculo> listarAtivos() {
        return veiculoDao.SelectAll();
    }

    @Override
    public void desativar(int id) {
        try {
            if (possuiOrdensAbertas(id)) {
                throw new Exception("Não é possível desativar o veículo pois ele possui ordens de serviço em aberto.");
            }
 
            veiculoDao.Desativar(id);
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void ativar(int id) {
        veiculoDao.Ativar(id);
    }

    @Override
    public void cadastrar(Veiculo veiculo) {
        try {
            VeiculoValidation.validar(
                veiculo.getPlaca(),
                veiculo.getMarca(),
                veiculo.getModelo(),
                veiculo.getAnoFabricacao(),
                veiculo.getAnoModelo()
            );
 
            if (placaJaCadastrada(veiculo.getPlaca())) {
                throw new Exception("Já existe um veículo cadastrado com esta placa.");
            }
 
            veiculoDao.insert(veiculo);
            JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso!");
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void atualizar(Veiculo veiculo) {
        try {
            VeiculoValidation.validar(
                veiculo.getPlaca(),
                veiculo.getMarca(),
                veiculo.getModelo(),
                veiculo.getAnoFabricacao(),
                veiculo.getAnoModelo()
            );
 
            Veiculo veiculoExistente = veiculoDao.SelectPorID(veiculo.getID());
            if (veiculoExistente != null && !veiculoExistente.getPlaca().equals(veiculo.getPlaca()) && placaJaCadastrada(veiculo.getPlaca())) {
                throw new Exception("Já existe um veículo cadastrado com esta placa.");
            }
 
            veiculoDao.update(veiculo);
            JOptionPane.showMessageDialog(null, "Veículo atualizado com sucesso!");
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public Veiculo buscarPorID(int id) {
        return veiculoDao.SelectPorID(id);
    }
    
     private boolean placaJaCadastrada(String placa) {
        List<Veiculo> veiculos = veiculoDao.SelectAll();
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return true;
            }
        }
        return false;
    }
 
    private boolean possuiOrdensAbertas(int idVeiculo) {
        List<OrdemServico> ordens = ordemServicoDao.SelectPorVeiculo(idVeiculo);
        for (OrdemServico o : ordens) {
            if (!o.getStatus().equals("Finalizada")) {
                return true;
            }
        }
        return false;
    }
    
}
