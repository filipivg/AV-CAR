/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.respository;

import com.av_car_auto_center.model.Fornecedor;
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
public class FornecedorDao implements DaoCadastro<Fornecedor>{

    @Override
    public void Desativar(int ID) {
        String sql = "update Fornecedor set Ativo = false where IDFornecedor = ? and Ativo = true";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, ID);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Fornecedor desativado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Fornecedor não encontrado!");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao desativar fornecedor: " + e.getMessage());
        }
    }

    @Override
    public void Ativar(int ID) {
        String sql = "update Fornecedor set Ativo = true where IDFornecedor = ? and Ativo = false";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, ID);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Fornecedor ativado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Fornecedor não encontrado!");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ativar fornecedor: " + e.getMessage());
        }
    }

    @Override
    public void insert(Fornecedor fornecedor) {
        String sql = "insert into Fornecedor(Ativo, NomeFornecedor, Telefone, Email) values (?,?,?,?)";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setBoolean(1, fornecedor.isAtivo());
            ps.setString(2, fornecedor.getNomeFornecedor());
            ps.setString(3, fornecedor.getTelefone());
            ps.setString(4, fornecedor.getEmail());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Cadastrar Fornecedor: " + e.getMessage());
        }
    }

    @Override
    public void update(Fornecedor fornecedor) {
        String sql = "update Fornecedor set Ativo = ?, NomeFornecedor = ?, Telefone = ?, Email = ? where IDFornecedor = ?";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setBoolean(1, fornecedor.isAtivo());
            ps.setString(2, fornecedor.getNomeFornecedor());
            ps.setString(3, fornecedor.getTelefone());
            ps.setString(4, fornecedor.getEmail());
            ps.setInt(5, fornecedor.getID());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Atualizar Fornecedor: " + e.getMessage());
        }
    }

    @Override
    public Fornecedor SelectPorID(int id) {
        String sql = "select * from Fornecedor where IDFornecedor = ? and Ativo = true";
 
        Fornecedor fornecedor = null;

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                fornecedor = new Fornecedor();

                fornecedor.setID(rs.getInt("IDFornecedor"));
                fornecedor.setAtivo(rs.getBoolean("Ativo"));
                fornecedor.setNomeFornecedor(rs.getString("NomeFornecedor"));
                fornecedor.setTelefone(rs.getString("Telefone"));
                fornecedor.setEmail(rs.getString("Email"));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Fornecedor: " + e.getMessage());
        }

        return fornecedor;
    }

    @Override
    public List<Fornecedor> SelectAll() {
        String sql = "select * from Fornecedor where Ativo = true";
 
        List<Fornecedor> fornecedores = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setID(rs.getInt("IDFornecedor"));
                fornecedor.setAtivo(rs.getBoolean("Ativo"));
                fornecedor.setNomeFornecedor(rs.getString("NomeFornecedor"));
                fornecedor.setTelefone(rs.getString("Telefone"));
                fornecedor.setEmail(rs.getString("Email"));

                fornecedores.add(fornecedor);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Fornecedores: " + e.getMessage());
        }

        return fornecedores;
    }
}
