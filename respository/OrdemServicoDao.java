package com.av_car_auto_center.respository;

import com.av_car_auto_center.model.OrdemServico;
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
public class OrdemServicoDao implements GenericDao<OrdemServico>{

    @Override
    public void insert(OrdemServico ordemServico) {
        String sql = "insert into OrdemServico(NomeCliente, DataAbertura, DataFinalizacao, Valor, Status, IDVeiculo) values (?,?,?,?,?,?)";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setString(1, ordemServico.getNomeCliente());
            ps.setDate(2, new java.sql.Date(ordemServico.getDataAbertura().getTime()));

            if (ordemServico.getDataFinalizacao() != null) {
                ps.setDate(3, new java.sql.Date(ordemServico.getDataFinalizacao().getTime()));
            } else {
                ps.setNull(3, java.sql.Types.DATE);
            }

            ps.setDouble(4, ordemServico.getValor());
            ps.setString(5, ordemServico.getStatus());
            ps.setInt(6, ordemServico.getVeiculo().getID());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Cadastrar Ordem de Serviço: " + e.getMessage());
        }
    }

    @Override
    public void update(OrdemServico ordemServico) {
        String sql = "update OrdemServico set NomeCliente = ?, DataAbertura = ?, DataFinalizacao = ?, Valor = ?, Status = ?, IDVeiculo = ? where iDOrdemservico = ?";
 
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setString(1, ordemServico.getNomeCliente());
            ps.setDate(2, new java.sql.Date(ordemServico.getDataAbertura().getTime()));

            if (ordemServico.getDataFinalizacao() != null) {
                ps.setDate(3, new java.sql.Date(ordemServico.getDataFinalizacao().getTime()));
            } else {
                ps.setNull(3, java.sql.Types.DATE);
            }

            ps.setDouble(4, ordemServico.getValor());
            ps.setString(5, ordemServico.getStatus());
            ps.setInt(6, ordemServico.getVeiculo().getID());
            ps.setInt(7, ordemServico.getID());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Atualizar Ordem de Serviço: " + e.getMessage());
        }
    }

    @Override
    public OrdemServico SelectPorID(int id) {
        String sql = "select * from OrdemServico where iDOrdemservico = ?";
 
        OrdemServico ordemServico = null;

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setID(rs.getInt("IDVeiculo"));

                java.sql.Date dataFinalizacaoSql = rs.getDate("DataFinalizacao");
                Date dataFinalizacao = dataFinalizacaoSql != null ? new Date(dataFinalizacaoSql.getTime()) : null;

                ordemServico = new OrdemServico(
                    rs.getInt("iDOrdemservico"),
                    veiculo,
                    rs.getString("NomeCliente"),
                    new Date(rs.getDate("DataAbertura").getTime()),
                    dataFinalizacao,
                    rs.getDouble("Valor"),
                    rs.getString("Status")
                );
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Ordem de Serviço: " + e.getMessage());
        }

        return ordemServico;
    }

    @Override
    public List<OrdemServico> SelectAll() {
        String sql = "select * from OrdemServico";
 
        List<OrdemServico> ordens = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setID(rs.getInt("IDVeiculo"));

                java.sql.Date dataFinalizacaoSql = rs.getDate("DataFinalizacao");
                Date dataFinalizacao = dataFinalizacaoSql != null ? new Date(dataFinalizacaoSql.getTime()) : null;

                OrdemServico ordemServico = new OrdemServico(
                    rs.getInt("iDOrdemservico"),
                    veiculo,
                    rs.getString("NomeCliente"),
                    new Date(rs.getDate("DataAbertura").getTime()),
                    dataFinalizacao,
                    rs.getDouble("Valor"),
                    rs.getString("Status")
                );

                ordens.add(ordemServico);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Ordens de Serviço: " + e.getMessage());
        }

        return ordens;
    }
    
    public List<OrdemServico> SelectPorCliente(String nomeCliente) {
        String sql = "select * from OrdemServico where NomeCliente = ?";

        List<OrdemServico> ordens = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setString(1, nomeCliente);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setID(rs.getInt("IDVeiculo"));

                java.sql.Date dataFinalizacaoSql = rs.getDate("DataFinalizacao");
                Date dataFinalizacao = dataFinalizacaoSql != null ? new Date(dataFinalizacaoSql.getTime()) : null;

                OrdemServico ordemServico = new OrdemServico(
                    rs.getInt("iDOrdemservico"),
                    veiculo,
                    rs.getString("NomeCliente"),
                    new Date(rs.getDate("DataAbertura").getTime()),
                    dataFinalizacao,
                    rs.getDouble("Valor"),
                    rs.getString("Status")
                );

                ordens.add(ordemServico);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Ordens do Cliente: " + e.getMessage());
        }

        return ordens;
    }
    
    public List<OrdemServico> SelectPorVeiculo(int idVeiculo) {
        String sql = "select * from OrdemServico where IDVeiculo = ?";

        List<OrdemServico> ordens = new ArrayList<>();

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setInt(1, idVeiculo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setID(rs.getInt("IDVeiculo"));

                java.sql.Date dataFinalizacaoSql = rs.getDate("DataFinalizacao");
                Date dataFinalizacao = dataFinalizacaoSql != null ? new Date(dataFinalizacaoSql.getTime()) : null;

                OrdemServico ordemServico = new OrdemServico(
                    rs.getInt("iDOrdemservico"),
                    veiculo,
                    rs.getString("NomeCliente"),
                    new Date(rs.getDate("DataAbertura").getTime()),
                    dataFinalizacao,
                    rs.getDouble("Valor"),
                    rs.getString("Status")
                );

                ordens.add(ordemServico);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Ao Buscar Ordens do Veículo: " + e.getMessage());
        }

        return ordens;
    }
    
    
}
