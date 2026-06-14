/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.respository;

import com.av_car_auto_center.model.Pagamento;
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
public class PagamentoDao implements GenericDao<Pagamento>{

    @Override
    public void insert(Pagamento pagamento) {
        String sql = "insert into Pagamento(DataPagamento, Valor) values (?,?)";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(pagamento.getDataPagamento().getTime()));
            ps.setDouble(2, pagamento.getValor());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Cadastrar Pagamento: " + e.getMessage());
        }
    }

    @Override
    public void update(Pagamento pagamento) {
        String sql = "update Pagamento set DataPagamento = ?, Valor = ? where IDPagamentos = ?";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(pagamento.getDataPagamento().getTime()));
            ps.setDouble(2, pagamento.getValor());
            ps.setInt(3, pagamento.getID());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Atualizar Pagamento: " + e.getMessage());
        }
    }

    @Override
    public Pagamento SelectPorID(int id) {
        String sql = "select * from Pagamento where IDPagamentos = ?";
 
        Pagamento pagamento = null;

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pagamento = new Pagamento(
                    rs.getInt("IDPagamentos"),
                    new Date(rs.getDate("DataPagamento").getTime()),
                    rs.getDouble("Valor")
                );
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Pagamento: " + e.getMessage());
        }

        return pagamento;
    }

    @Override
    public List<Pagamento> SelectAll() {
        String sql = "select * from Pagamento";
 
        List<Pagamento> pagamentos = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pagamento pagamento = new Pagamento(
                    rs.getInt("IDPagamentos"),
                    new Date(rs.getDate("DataPagamento").getTime()),
                    rs.getDouble("Valor")
                );

                pagamentos.add(pagamento);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Pagamentos: " + e.getMessage());
        }

        return pagamentos;
    }
    
    
}
