/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.respository;

import com.av_car_auto_center.model.OrdemServico;
import com.av_car_auto_center.model.OrdemServicoServico;
import com.av_car_auto_center.model.Servico;
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
public class OrdemServicoServicoDao implements GenericDao<OrdemServicoServico>{

    @Override
    public void insert(OrdemServicoServico ordemServicoServico) {
         String sql = "insert into OrdemServicoServico(IDOrdemServico, IDServico) values (?,?)";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, ordemServicoServico.getOrdemServico().getID());
            ps.setInt(2, ordemServicoServico.getServico().getID());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Cadastrar OrdemServicoServico: " + e.getMessage());
        }
    }

    @Override
    public void update(OrdemServicoServico obj) {
        throw new UnsupportedOperationException("Tabela de Relacionamento"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OrdemServicoServico SelectPorID(int id) {
        throw new UnsupportedOperationException("Não contem ID Proprio"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OrdemServicoServico> SelectAll() {
        String sql = "select * from OrdemServicoServico";
 
        List<OrdemServicoServico> lista = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OrdemServico ordemServico = new OrdemServico();
                ordemServico.setID(rs.getInt("IDOrdemServico"));

                Servico servico = new Servico();
                servico.setID(rs.getInt("IDServico"));

                lista.add(new OrdemServicoServico(ordemServico, servico));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar OrdemServicoServico: " + e.getMessage());
        }

        return lista;
    }
    

    public List<OrdemServicoServico> SelectPorOrdemServico(int idOrdemServico) {
        String sql = "select * from OrdemServicoServico where IDOrdemServico = ?";

        List<OrdemServicoServico> lista = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, idOrdemServico);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OrdemServico ordemServico = new OrdemServico();
                ordemServico.setID(rs.getInt("IDOrdemServico"));

                Servico servico = new Servico();
                servico.setID(rs.getInt("IDServico"));

                lista.add(new OrdemServicoServico(ordemServico, servico));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Serviços da Ordem de Serviço: " + e.getMessage());
        }

        return lista;
    }

    public List<OrdemServicoServico> SelectPorServico(int idServico) {
        String sql = "select * from OrdemServicoServico where IDServico = ?";

        List<OrdemServicoServico> lista = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, idServico);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OrdemServico ordemServico = new OrdemServico();
                ordemServico.setID(rs.getInt("IDOrdemServico"));

                Servico servico = new Servico();
                servico.setID(rs.getInt("IDServico"));

                lista.add(new OrdemServicoServico(ordemServico, servico));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Ordens de Serviço do Serviço: " + e.getMessage());
        }

        return lista;
    }
}
