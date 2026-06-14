/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.respository;

import com.av_car_auto_center.model.OrdemServico;
import com.av_car_auto_center.model.OrdemServicoPeca;
import com.av_car_auto_center.model.Peca;
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
public class OrdemServicoPecaDao implements GenericDao<OrdemServicoPeca>{

    @Override
    public void insert(OrdemServicoPeca ordemServicoPeca) {
        String sql = "insert into OrdemServicoPeca(IDOrdemServico, IDPeca) values (?,?)";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, ordemServicoPeca.getOrdemServico().getID());
            ps.setInt(2, ordemServicoPeca.getPeca().getID());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Cadastrar OrdemServicoPeca: " + e.getMessage());
        }
    }

    @Override
    public void update(OrdemServicoPeca obj) {
        throw new UnsupportedOperationException("Tabela de Relacionamento"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OrdemServicoPeca SelectPorID(int id) {
        throw new UnsupportedOperationException("Não contem ID Proprio"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OrdemServicoPeca> SelectAll() {
        String sql = "select * from OrdemServicoPeca";
 
        List<OrdemServicoPeca> lista = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OrdemServico ordemServico = new OrdemServico();
                ordemServico.setID(rs.getInt("IDOrdemServico"));

                Peca peca = new Peca();
                peca.setID(rs.getInt("IDPeca"));

                lista.add(new OrdemServicoPeca(ordemServico, peca));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar OrdemServicoPeca: " + e.getMessage());
        }

        return lista;
    }
    

    public List<OrdemServicoPeca> SelectPorOrdemServico(int IDOrdemServico) {
        String sql = "select * from OrdemServicoPeca where IDOrdemServico = ?";

        List<OrdemServicoPeca> lista = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, IDOrdemServico);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OrdemServico ordemServico = new OrdemServico();
                ordemServico.setID(rs.getInt("IDOrdemServico"));

                Peca peca = new Peca();
                peca.setID(rs.getInt("IDPeca"));

                lista.add(new OrdemServicoPeca(ordemServico, peca));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Peças da Ordem de Serviço: " + e.getMessage());
        }

        return lista;
    }

    public List<OrdemServicoPeca> SelectPorPeca(int IDPeca) {
        String sql = "select * from OrdemServicoPeca where IDPeca = ?";

        List<OrdemServicoPeca> lista = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, IDPeca);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OrdemServico ordemServico = new OrdemServico();
                ordemServico.setID(rs.getInt("IDOrdemServico"));

                Peca peca = new Peca();
                peca.setID(rs.getInt("IDPeca"));

                lista.add(new OrdemServicoPeca(ordemServico, peca));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Ordens de Serviço da Peça: " + e.getMessage());
        }
        return lista;
    }
    
}
