/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.respository;

import com.av_car_auto_center.model.Colaborador;
import com.av_car_auto_center.model.ColaboradorFuncao;
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
public class ColaboradorFuncaoDao implements GenericDao<ColaboradorFuncao>{

    @Override
    public void insert(ColaboradorFuncao colaboradorFuncao) {
         String sql = "insert into ColaboradorFuncao(IDColaborador, IDFuncao) values (?,?)";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, colaboradorFuncao.getColaborador().getID());
            ps.setInt(2, colaboradorFuncao.getFuncao().getID());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Cadastrar ColaboradorFuncao: " + e.getMessage());
        }
    }

    @Override
    public void update(ColaboradorFuncao obj) {
        throw new UnsupportedOperationException("Tabela de Relacionamento"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ColaboradorFuncao SelectPorID(int id) {
        throw new UnsupportedOperationException("Não Contem ID Proprio"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ColaboradorFuncao> SelectAll() {
        String sql = "select * from ColaboradorFuncao";
 
        List<ColaboradorFuncao> lista = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Colaborador colaborador = new Colaborador();
                colaborador.setID(rs.getInt("IDColaborador"));

                Funcao funcao = new Funcao();
                funcao.setID(rs.getInt("IDFuncao"));

                lista.add(new ColaboradorFuncao(colaborador, funcao));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar ColaboradorFuncao: " + e.getMessage());
        }
        return lista;
    }
    
    
    public List<ColaboradorFuncao> SelectPorColaborador(int idColaborador) {
        String sql = "select * from ColaboradorFuncao where IDColaborador = ?";

        List<ColaboradorFuncao> lista = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, idColaborador);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Colaborador colaborador = new Colaborador();
                colaborador.setID(rs.getInt("IDColaborador"));

                Funcao funcao = new Funcao();
                funcao.setID(rs.getInt("IDFuncao"));

                lista.add(new ColaboradorFuncao(colaborador, funcao));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Funções do Colaborador: " + e.getMessage());
        }

        return lista;
    }

    public List<ColaboradorFuncao> SelectPorFuncao(int idFuncao) {
        String sql = "select * from ColaboradorFuncao where IDFuncao = ?";

        List<ColaboradorFuncao> lista = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, idFuncao);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Colaborador colaborador = new Colaborador();
                colaborador.setID(rs.getInt("IDColaborador"));

                Funcao funcao = new Funcao();
                funcao.setID(rs.getInt("IDFuncao"));

                lista.add(new ColaboradorFuncao(colaborador, funcao));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Colaboradores da Função: " + e.getMessage());
        }

        return lista;
    }
    
}
