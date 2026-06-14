    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.service;

import com.av_car_auto_center.model.Cliente;
import com.av_car_auto_center.model.OrdemServico;
import com.av_car_auto_center.respository.ClienteDao;
import com.av_car_auto_center.respository.OrdemServicoDao;
import com.av_car_auto_center.validation.ClienteValidation;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class ClienteService implements IGenericCadastroService<Cliente>{
    
    private final ClienteDao clienteDao;
    private final OrdemServicoDao ordemServicoDao;
 
    public ClienteService() {
        this.clienteDao = new ClienteDao();
        this.ordemServicoDao = new OrdemServicoDao();
    }
    
    @Override
    public List<Cliente> listarAtivos() {
        return clienteDao.SelectAll();
    }

    @Override
    public void desativar(int id) {
        try {
            if (possuiOrdensAbertas(id)) {
                throw new Exception("Não é possível desativar o cliente, pois ele possui ordens de serviço em aberto.");
            }
 
            clienteDao.Desativar(id);
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void ativar(int id) {
         clienteDao.Ativar(id);
    }

    @Override
    public void cadastrar(Cliente cliente) {
        try {
            ClienteValidation.validar(
                cliente.getTipoCliente(),
                cliente.getNomeRazaoSocial(),
                cliente.getCPF(),
                cliente.getTelefone(),
                cliente.getEmail()
            );
 
            if (cpfJaCadastrado(cliente.getCPF())) {
                throw new Exception("Já existe um cliente cadastrado com este CPF.");
            }
 
            clienteDao.insert(cliente);
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void atualizar(Cliente cliente) {
        try {
            ClienteValidation.validar(
                cliente.getTipoCliente(),
                cliente.getNomeRazaoSocial(),
                cliente.getCPF(),
                cliente.getTelefone(),
                cliente.getEmail()
            );
 
            Cliente clienteExistente = clienteDao.SelectPorID(cliente.getID());
            
            if (clienteExistente != null && !clienteExistente.getCPF().equals(cliente.getCPF()) && cpfJaCadastrado(cliente.getCPF())) {
                throw new Exception("Já existe um cliente cadastrado com este CPF.");
            }
 
            clienteDao.update(cliente);
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public Cliente buscarPorID(int id) {
        return clienteDao.SelectPorID(id);
    }

    private boolean cpfJaCadastrado(String cpf) {
        List<Cliente> clientes = clienteDao.SelectAll();
        for (Cliente c : clientes) {
            if (c.getCPF().equals(cpf)) {
                return true;
            }
        }
        return false;
    }
 
    private boolean possuiOrdensAbertas(int idCliente) {
        Cliente cliente = clienteDao.SelectPorID(idCliente);
        if (cliente == null) return false;
 
        List<OrdemServico> ordens = ordemServicoDao.SelectPorCliente(cliente.getNomeRazaoSocial());
        for (OrdemServico o : ordens) {
            if (!o.getStatus().equals("Finalizada")) {
                return true;
            }
        }
        return false;
    }
    
}

