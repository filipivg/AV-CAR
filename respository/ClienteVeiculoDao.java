/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.respository;

import com.av_car_auto_center.model.Cliente;
import com.av_car_auto_center.model.ClienteVeiculo;
import com.av_car_auto_center.model.Veiculo;
import com.av_car_auto_center.util.ConexaoDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class ClienteVeiculoDao implements GenericDao<ClienteVeiculo>{

    @Override
    public void insert(ClienteVeiculo clienteVeiculo) {
        String sql = "insert into ClienteVeiculo(IDCliente, IDVeiculo) values (?,?)";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, clienteVeiculo.getCliente().getID());
            ps.setInt(2, clienteVeiculo.getVeiculo().getID());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Cadastrar ClienteVeiculo: " + e.getMessage());
        }
    }

    @Override
    public void update(ClienteVeiculo obj) {
        throw new UnsupportedOperationException("Tabela de Relacionamento"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ClienteVeiculo SelectPorID(int id) {
        throw new UnsupportedOperationException("Não contem ID Proprio"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ClienteVeiculo> SelectAll() {
        String sql = "select * from ClienteVeiculo";
 
        List<ClienteVeiculo> lista = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setID(rs.getInt("IDCliente"));

                Veiculo veiculo = new Veiculo();
                veiculo.setID(rs.getInt("IDVeiculo"));

                lista.add(new ClienteVeiculo(cliente, veiculo));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar ClienteVeiculo: " + e.getMessage());
        }

        return lista;
    }
    
     
    public List<ClienteVeiculo> SelectPorCliente(int IDCliente) {
        String sql = "select * from ClienteVeiculo where IDCliente = ?";

        List<ClienteVeiculo> lista = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, IDCliente);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setID(rs.getInt("IDCliente"));

                Veiculo veiculo = new Veiculo();
                veiculo.setID(rs.getInt("IDVeiculo"));

                lista.add(new ClienteVeiculo(cliente, veiculo));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Veículos do Cliente: " + e.getMessage());
        }

        return lista;
    }

    public List<ClienteVeiculo> SelectPorVeiculo(int IDVeiculo) {
        String sql = "select * from ClienteVeiculo where IDVeiculo = ?";

        List<ClienteVeiculo> lista = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, IDVeiculo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setID(rs.getInt("IDCliente"));

                Veiculo veiculo = new Veiculo();
                veiculo.setID(rs.getInt("IDVeiculo"));

                lista.add(new ClienteVeiculo(cliente, veiculo));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Clientes do Veículo: " + e.getMessage());
        }

        return lista;
    }
    
}
