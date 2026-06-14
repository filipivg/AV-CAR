package com.av_car_auto_center.respository;

import com.av_car_auto_center.model.Cliente;
import com.av_car_auto_center.util.ConexaoDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDao implements DaoCadastro<Cliente>{

    @Override
    public void insert(Cliente cliente){
        String sql = "insert into Cliente(TipoCliente,Ativo,NomeRazaoSocial,CPF,Telefone,Email) values (?,?,?,?,?,?)";
        
        try{
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);
            ps.setString(1, cliente.getTipoCliente());
            ps.setBoolean(2, cliente.isAtivo());
            ps.setString(3, cliente.getNomeRazaoSocial());
            ps.setString(4, cliente.getCPF());
            ps.setString(5, cliente.getTelefone());
            ps.setString(6, cliente.getEmail());
            
            
            ps.execute();
            ps.close();
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,"Erro Ao Cadastrar Cliente: "+e.getMessage());
        }
    }

    @Override
    public void update(Cliente cliente) {
        String sql = "update Cliente set TipoCliente = ?, Ativo = ?, NomeRazaoSocial = ?, CPF = ?, Telefone = ?, Email = ? where IDCliente = ?";

        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);

            ps.setString(1, cliente.getTipoCliente());
            ps.setBoolean(2, cliente.isAtivo());
            ps.setString(3, cliente.getNomeRazaoSocial());
            ps.setString(4, cliente.getCPF());
            ps.setString(5, cliente.getTelefone());
            ps.setString(6, cliente.getEmail());

            ps.setInt(7, cliente.getID());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null,"Erro Ao Atualizar Cliente: "+e.getMessage());

        }
    }
    
    @Override
    public List<Cliente> SelectAll() {

        String sql = "select * from Cliente where Ativo = true";
        
        List<Cliente> clientes = new ArrayList<>();

        try {

            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setID(rs.getInt("IDCliente"));
                cliente.setAtivo(rs.getBoolean("Ativo"));
                cliente.setTipoCliente(rs.getString("TipoCliente"));
                cliente.setNomeRazaoSocial(rs.getString("NomeRazaoSocial"));
                cliente.setCPF(rs.getString("CPF"));
                cliente.setTelefone(rs.getString("Telefone"));
                cliente.setEmail(rs.getString("Email"));

                clientes.add(cliente);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro Ao Buscar Clientes: "+e.getMessage());
        }

        return clientes; 
    }

    @Override
    public void Desativar(int ID) {
            String sql = "update Cliente set Ativo = false where IDCliente = ? and Ativo = true";
        try {
            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);

            ps.setInt(1, ID);

            int linhasAfetadas = ps.executeUpdate();

            if(linhasAfetadas > 0){
                JOptionPane.showMessageDialog(null, "Cliente desativado com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null,"Cliente não encontrado!");
            }

            ps.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null,"Erro ao desativar cliente: "+ e.getMessage()
            );
        }
    }

    @Override
    public void Ativar(int ID) {
           String sql = "update Cliente set Ativo = true where IDCliente = ? and Ativo = false";

        try {

            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);

            ps.setInt(1, ID);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {

                JOptionPane.showMessageDialog(null, "Cliente Ativado com sucesso!");

            } else {

                JOptionPane.showMessageDialog(null,"Cliente não encontrado!");
            }

            ps.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null,"Erro ao Ativar cliente: "+ e.getMessage()
            );
        }
    }

    @Override
    public Cliente SelectPorID(int id) {
        String sql = "select * from Cliente where IDCliente = ? and Ativo = true";

        Cliente cliente = null;

        try {

            PreparedStatement ps = ConexaoDB.abrirConn().prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                cliente = new Cliente();

                cliente.setID(rs.getInt("IDCliente"));
                cliente.setAtivo(rs.getBoolean("Ativo"));
                cliente.setTipoCliente(rs.getString("TipoCliente"));
                cliente.setNomeRazaoSocial(rs.getString("NomeRazaoSocial"));
                cliente.setCPF(rs.getString("CPF"));
                cliente.setTelefone(rs.getString("Telefone"));
                cliente.setEmail(rs.getString("Email"));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro Ao Buscar Cliente: "+e.getMessage());
        }
        return cliente;
    }
}
