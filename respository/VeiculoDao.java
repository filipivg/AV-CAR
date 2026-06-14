/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.respository;

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
public class VeiculoDao implements DaoCadastro<Veiculo>{

    @Override
    public void Desativar(int ID) {
        String sql = "update Veiculo set Ativo = false where IDVeiculo = ? and Ativo = true";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, ID);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Veículo desativado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Veículo não encontrado!");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao desativar veículo: " + e.getMessage());
        }    
    }

    @Override
    public void Ativar(int ID) {
        String sql = "update Veiculo set Ativo = true where IDVeiculo = ? and Ativo = false";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, ID);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Veículo ativado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Veículo não encontrado!");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ativar veículo: " + e.getMessage());
        }
    }

    @Override
    public void insert(Veiculo veiculo) {
        String sql = "insert into Veiculo(Ativo, Placa, Marca, Modelo, AnoFabricacao, AnoModelo) values (?,?,?,?,?,?)";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setBoolean(1, veiculo.isAtivo());
            ps.setString(2, veiculo.getPlaca());
            ps.setString(3, veiculo.getMarca());
            ps.setString(4, veiculo.getModelo());
            ps.setInt(5, veiculo.getAnoFabricacao());
            ps.setInt(6, veiculo.getAnoModelo());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Cadastrar Veículo: " + e.getMessage());
        }
    }

    @Override
    public void update(Veiculo veiculo) {
        String sql = "update Veiculo set Ativo = ?, Placa = ?, Marca = ?, Modelo = ?, AnoFabricacao = ?, AnoModelo = ? where IDVeiculo = ?";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setBoolean(1, veiculo.isAtivo());
            ps.setString(2, veiculo.getPlaca());
            ps.setString(3, veiculo.getMarca());
            ps.setString(4, veiculo.getModelo());
            ps.setInt(5, veiculo.getAnoFabricacao());
            ps.setInt(6, veiculo.getAnoModelo());
            ps.setInt(7, veiculo.getID());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Atualizar Veículo: " + e.getMessage());
        }
    }

    @Override
    public Veiculo SelectPorID(int id) {
        String sql = "select * from Veiculo where IDVeiculo = ? and Ativo = true";
 
        Veiculo veiculo = null;

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                veiculo = new Veiculo();

                veiculo.setID(rs.getInt("IDVeiculo"));
                veiculo.setAtivo(rs.getBoolean("Ativo"));
                veiculo.setPlaca(rs.getString("Placa"));
                veiculo.setMarca(rs.getString("Marca"));
                veiculo.setModelo(rs.getString("Modelo"));
                veiculo.setAnoFabricacao(rs.getInt("AnoFabricacao"));
                veiculo.setAnoModelo(rs.getInt("AnoModelo"));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Veículo: " + e.getMessage());
        }

        return veiculo;
    }

    @Override
    public List<Veiculo> SelectAll() {
        String sql = "select * from Veiculo where Ativo = true";
 
    List<Veiculo> veiculos = new ArrayList<>();
 
    try {
        PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
 
        while (rs.next()) {
            
            Veiculo veiculo = new Veiculo();
 
            veiculo.setID(rs.getInt("IDVeiculo"));
            veiculo.setAtivo(rs.getBoolean("Ativo"));
            veiculo.setPlaca(rs.getString("Placa"));
            veiculo.setMarca(rs.getString("Marca"));
            veiculo.setModelo(rs.getString("Modelo"));
            veiculo.setAnoFabricacao(rs.getInt("AnoFabricacao"));
            veiculo.setAnoModelo(rs.getInt("AnoModelo"));
 
            veiculos.add(veiculo);
        }
 
        rs.close();
        ps.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro Ao Buscar Veículos: " + e.getMessage());
    }
 
    return veiculos;
    }
}
