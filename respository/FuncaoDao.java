/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.respository;

import com.av_car_auto_center.model.Funcao;
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
public class FuncaoDao implements DaoCadastro<Funcao>{

    @Override
    public void Desativar(int ID) {
        String sql = "update Funcao set Ativo = false where IDFuncao = ? and Ativo = true";

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, ID);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Função desativada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Função não encontrada!");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao desativar função: " + e.getMessage());
        }
    }

    @Override
    public void Ativar(int ID) {
        String sql = "update Funcao set Ativo = true where IDFuncao = ? and Ativo = false";

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, ID);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Função ativada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Função não encontrada!");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ativar função: " + e.getMessage());
        }
    }

    @Override
    public void insert(Funcao funcao) {
        String sql = "insert into Funcao(Ativo, Descricao) values (?, ?)";

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setBoolean(1, funcao.isAtivo());
            ps.setString(2, funcao.getDescricao());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Cadastrar Função: " + e.getMessage());
        }
    }

    @Override
    public void update(Funcao funcao) {
        String sql = "update Funcao set Ativo = ?, Descricao = ? where IDFuncao = ?";

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setBoolean(1, funcao.isAtivo());
            ps.setString(2, funcao.getDescricao());
            ps.setInt(3, funcao.getID());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Atualizar Função: " + e.getMessage());
        }
    }

    @Override
    public Funcao SelectPorID(int id) {
         String sql = "select * from Funcao where IDFuncao = ? and Ativo = true";

        Funcao funcao = null;

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                funcao = new Funcao(
                    rs.getInt("IDFuncao"),
                    rs.getBoolean("Ativo"),
                    rs.getString("Descricao")
                );
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Função: " + e.getMessage());
        }

        return funcao;
    }

    @Override
    public List<Funcao> SelectAll() {
        String sql = "select * from Funcao where Ativo = true";

        List<Funcao> funcoes = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Funcao funcao = new Funcao(
                    rs.getInt("IDFuncao"),
                    rs.getBoolean("Ativo"),
                    rs.getString("Descricao")
                );

                funcoes.add(funcao);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Funções: " + e.getMessage());
        }

        return funcoes;
    }
    
}
