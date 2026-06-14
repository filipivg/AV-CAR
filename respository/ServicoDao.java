/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.respository;

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
public class ServicoDao implements DaoCadastro<Servico>{

    @Override
    public void Desativar(int ID) {
        String sql = "update Servico set Ativo = false where IDServico = ? and Ativo = true";

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, ID);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Serviço desativado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Serviço não encontrado!");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao desativar serviço: " + e.getMessage());
        }
    }

    @Override
    public void Ativar(int ID) {
        String sql = "update Servico set Ativo = true where IDServico = ? and Ativo = false";

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, ID);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Serviço ativado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Serviço não encontrado!");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ativar serviço: " + e.getMessage());
        }
    }

    @Override
    public void insert(Servico servico) {
        String sql = "insert into Servico(Ativo, Descricao, PrazoGarantia, TipoServico, Valor) values (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setBoolean(1, servico.isAtivo());
            ps.setString(2, servico.getDescricao());
            ps.setInt(3, servico.getPrazoGarantia());
            ps.setString(4, servico.getTipoServico());
            ps.setDouble(5, servico.getValor());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Cadastrar Serviço: " + e.getMessage());
        }
    }

    @Override
    public void update(Servico servico) {
        String sql = "update Servico set Ativo = ?, Descricao = ?, PrazoGarantia = ?, TipoServico = ?, Valor = ? where IDServico = ?";

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setBoolean(1, servico.isAtivo());
            ps.setString(2, servico.getDescricao());
            ps.setInt(3, servico.getPrazoGarantia());
            ps.setString(4, servico.getTipoServico());
            ps.setDouble(5, servico.getValor());
            ps.setInt(6, servico.getID());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Atualizar Serviço: " + e.getMessage());
        }
    }

    @Override
    public Servico SelectPorID(int id) {
         String sql = "select * from Servico where IDServico = ? and Ativo = true";

        Servico servico = null;

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                servico = new Servico(
                    rs.getInt("IDServico"),
                    rs.getBoolean("Ativo"),
                    rs.getString("Descricao"),
                    rs.getInt("PrazoGarantia"),
                    rs.getString("TipoServico"),
                    rs.getDouble("Valor")
                );
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Serviço: " + e.getMessage());
        }

        return servico;
    }

    @Override
    public List<Servico> SelectAll() {
        String sql = "select * from Servico where Ativo = true";

        List<Servico> servicos = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Servico servico = new Servico(
                    rs.getInt("IDServico"),
                    rs.getBoolean("Ativo"),
                    rs.getString("Descricao"),
                    rs.getInt("PrazoGarantia"),
                    rs.getString("TipoServico"),
                    rs.getDouble("Valor")
                );

                servicos.add(servico);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Serviços: " + e.getMessage());
        }

        return servicos;
    }
    
}
