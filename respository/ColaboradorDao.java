/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.respository;

import com.av_car_auto_center.model.Colaborador;
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
public class ColaboradorDao implements DaoCadastro<Colaborador> {

    @Override
    public void Desativar(int ID) {
        String sql = "update Colaborador set Ativo = false where IDColaborador = ? and Ativo = true";

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, ID);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Colaborador desativado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Colaborador não encontrado!");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao desativar colaborador: " + e.getMessage());
        }
    }

    @Override
    public void Ativar(int ID) {
        String sql = "update Colaborador set Ativo = true where IDColaborador = ? and Ativo = false";

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, ID);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Colaborador ativado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Colaborador não encontrado!");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ativar colaborador: " + e.getMessage());
        }
    }

    @Override
    public void insert(Colaborador colaborador) {
        String sql = "insert into Colaborador(Ativo, NomeColaborador) values (?, ?)";

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setBoolean(1, colaborador.isAtivo());
            ps.setString(2, colaborador.getNome());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Cadastrar Colaborador: " + e.getMessage());
        }
    }

    @Override
    public void update(Colaborador colaborador) {
        String sql = "update Colaborador set Ativo = ?, NomeColaborador = ? where IDColaborador = ?";

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setBoolean(1, colaborador.isAtivo());
            ps.setString(2, colaborador.getNome());
            ps.setInt(3, colaborador.getID());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Atualizar Colaborador: " + e.getMessage());
        }
    }

    @Override
    public Colaborador SelectPorID(int id) {
        String sql = "select * from Colaborador where IDColaborador = ? and Ativo = true";

        Colaborador colaborador = null;

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                colaborador = new Colaborador(
                    rs.getInt("IDColaborador"),
                    rs.getBoolean("Ativo"),
                    rs.getString("NomeColaborador")
                );
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Colaborador: " + e.getMessage());
        }
        return colaborador;
    }

    @Override
    public List<Colaborador> SelectAll() {
        String sql = "select * from Colaborador where Ativo = true";

        List<Colaborador> colaboradores = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Colaborador colaborador = new Colaborador(
                    rs.getInt("IDColaborador"),
                    rs.getBoolean("Ativo"),
                    rs.getString("NomeColaborador")
                );

                colaboradores.add(colaborador);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Colaboradores: " + e.getMessage());
        }

        return colaboradores;
    }
}
