/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.Controller;

import com.av_car_auto_center.model.Cliente;
import com.av_car_auto_center.model.ClienteVeiculo;
import com.av_car_auto_center.respository.ClienteVeiculoDao;
import com.av_car_auto_center.service.ClienteService;
import java.util.List;

/**
 *
 * @author gusta
 */
public class ClienteController implements IGenericCadastroController<Cliente>{
    
    private final ClienteService clienteService;
    private final ClienteVeiculoDao clienteVeiculoDao;
 
    public ClienteController() {
        this.clienteService = new ClienteService();
        this.clienteVeiculoDao = new ClienteVeiculoDao();
    }
    
    @Override
    public List<Cliente> listarAtivos() {
        return clienteService.listarAtivos();
    }

    @Override
    public void desativar(int id) {
        clienteService.desativar(id);   
    }

    @Override
    public void ativar(int id) {
        clienteService.ativar(id);
    }

    @Override
    public void cadastrar(Cliente cliente) {
        clienteService.cadastrar(cliente);
    }

    @Override
    public void atualizar(Cliente cliente) {
        clienteService.atualizar(cliente);
    }

    @Override
    public Cliente buscarPorID(int id) {
        return clienteService.buscarPorID(id);
    }
    
    // ---- ClienteVeiculo ----
 
    public void vincularVeiculo(ClienteVeiculo clienteVeiculo) {
        clienteVeiculoDao.insert(clienteVeiculo);
    }
 
    public List<ClienteVeiculo> listarVeiculosDoCliente(int idCliente) {
        return clienteVeiculoDao.SelectPorCliente(idCliente);
    }
 
    public List<ClienteVeiculo> listarClientesDoVeiculo(int idVeiculo) {
        return clienteVeiculoDao.SelectPorVeiculo(idVeiculo);
    }
    
    
}
