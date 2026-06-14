/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.respository;

import com.av_car_auto_center.model.Fornecedor;
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
public class PecaDao implements DaoCadastro<Peca>{

    @Override
    public void Desativar(int ID) {
        String sql = "update Peca set Ativo = false where IDPeca = ? and Ativo = true";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, ID);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Peça desativada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Peça não encontrada!");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao desativar peça: " + e.getMessage());
        }
    }

    @Override
    public void Ativar(int ID) {
        String sql = "update Peca set Ativo = true where IDPeca = ? and Ativo = false";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, ID);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Peça ativada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Peça não encontrada!");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ativar peça: " + e.getMessage());
        }
    }

    @Override
    public void insert(Peca peca) {
       String sql = "insert into Peca(Ativo, CodigoNacional, Descricao, PrazoGarantia, IDFornecedor) values (?,?,?,?,?)";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setBoolean(1, peca.isAtivo());
            ps.setString(2, peca.getCodigoNacional());
            ps.setString(3, peca.getDescricao());
            ps.setInt(4, peca.getPrazoGarantia());
            ps.setInt(5, peca.getFornecedor().getID());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Cadastrar Peça: " + e.getMessage());
        }
    }

    @Override
    public void update(Peca peca) {
        String sql = "update Peca set Ativo = ?, CodigoNacional = ?, Descricao = ?, PrazoGarantia = ?, IDFornecedor = ? where IDPeca = ?";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setBoolean(1, peca.isAtivo());
            ps.setString(2, peca.getCodigoNacional());
            ps.setString(3, peca.getDescricao());
            ps.setInt(4, peca.getPrazoGarantia());
            ps.setInt(5, peca.getFornecedor().getID());
            ps.setInt(6, peca.getID());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Atualizar Peça: " + e.getMessage());
        }
    }

    @Override
    public Peca SelectPorID(int id) {
       String sql = "select * from Peca where IDPeca = ? and Ativo = true";
 
        Peca peca = null;

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setID(rs.getInt("IDFornecedor"));

                peca = new Peca(
                    rs.getInt("IDPeca"),
                    rs.getBoolean("Ativo"),
                    fornecedor,
                    rs.getString("CodigoNacional"),
                    rs.getString("Descricao"),
                    rs.getInt("PrazoGarantia")
                );
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Peça: " + e.getMessage());
        }

        return peca;
    }

    @Override
    public List<Peca> SelectAll() {
        String sql = "select * from Peca where Ativo = true";
 
        List<Peca> pecas = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                
                fornecedor.setID(rs.getInt("IDFornecedor"));

                Peca peca = new Peca(
                    rs.getInt("IDPeca"),
                    rs.getBoolean("Ativo"),
                    fornecedor,
                    rs.getString("CodigoNacional"),
                    rs.getString("Descricao"),
                    rs.getInt("PrazoGarantia")
                );

                pecas.add(peca);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Peças: " + e.getMessage());
        }

        return pecas;
    }
    
}
