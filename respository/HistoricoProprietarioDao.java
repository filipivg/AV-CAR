/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.respository;

import com.av_car_auto_center.model.Cliente;
import com.av_car_auto_center.model.HistoricoProprietario;
import com.av_car_auto_center.model.Veiculo;
import com.av_car_auto_center.util.ConexaoDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class HistoricoProprietarioDao implements GenericDao<HistoricoProprietario>{

    @Override
    public void insert(HistoricoProprietario historico) {
        String sql = "insert into HistoricoProprietario(DataInicio, DataFim, IDVeiculo, IDCliente) values (?,?,?,?)";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(historico.getDataInicio().getTime()));

            if (historico.getDataFim() != null) {
                ps.setDate(2, new java.sql.Date(historico.getDataFim().getTime()));
            } else {
                ps.setNull(2, java.sql.Types.DATE);
            }

            ps.setInt(3, historico.getVeiculo().getID());
            ps.setInt(4, historico.getCliente().getID());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Cadastrar Histórico: " + e.getMessage());
        }
    }

    @Override
    public void update(HistoricoProprietario historico) {
        String sql = "update HistoricoProprietario set DataInicio = ?, DataFim = ?, IDVeiculo = ?, IDCliente = ? where IDHistorico = ?";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(historico.getDataInicio().getTime()));

            if (historico.getDataFim() != null) {
                ps.setDate(2, new java.sql.Date(historico.getDataFim().getTime()));
            } else {
                ps.setNull(2, java.sql.Types.DATE);
            }

            ps.setInt(3, historico.getVeiculo().getID());
            ps.setInt(4, historico.getCliente().getID());
            ps.setInt(5, historico.getID());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Atualizar Histórico: " + e.getMessage());
        }
    }

    @Override
    public HistoricoProprietario SelectPorID(int id) {
        String sql = "select * from HistoricoProprietario where IDHistorico = ?";
 
        HistoricoProprietario historico = null;

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setID(rs.getInt("IDVeiculo"));

                Cliente cliente = new Cliente();
                cliente.setID(rs.getInt("IDCliente"));

                java.sql.Date dataFimSql = rs.getDate("DataFim");
                Date dataFim = dataFimSql != null ? new Date(dataFimSql.getTime()) : null;

                historico = new HistoricoProprietario(
                    rs.getInt("IDHistorico"),
                    new Date(rs.getDate("DataInicio").getTime()),
                    dataFim,
                    veiculo,
                    cliente
                );
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Histórico: " + e.getMessage());
        }

        return historico;
    }

    @Override
    public List<HistoricoProprietario> SelectAll() {
         String sql = "select * from HistoricoProprietario";
 
        List<HistoricoProprietario> historicos = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setID(rs.getInt("IDVeiculo"));

                Cliente cliente = new Cliente();
                cliente.setID(rs.getInt("IDCliente"));

                java.sql.Date dataFimSql = rs.getDate("DataFim");
                Date dataFim = dataFimSql != null ? new Date(dataFimSql.getTime()) : null;

                HistoricoProprietario historico = new HistoricoProprietario(
                    rs.getInt("IDHistorico"),
                    new Date(rs.getDate("DataInicio").getTime()),
                    dataFim,
                    veiculo,
                    cliente
                );

                historicos.add(historico);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Históricos: " + e.getMessage());
        }

        return historicos;
    }
    
}
