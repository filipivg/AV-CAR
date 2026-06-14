package com.av_car_auto_center.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDB {
    
    private static final String URL = "jdbc:mysql://localhost:3308/projeto_integrador";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String CLASS_FOR_NAME = "com.mysql.cj.jdbc.Driver";
    private static Connection conn = null;
    
    public static Connection abrirConn(){
        try{
            if(conn == null || conn.isClosed()){
                Class.forName(CLASS_FOR_NAME);
                conn = DriverManager.getConnection(URL,USER,PASSWORD);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao Conectar" + e);
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Erro de Conexão" + e);
        }
        return conn;
    }
    public static void fecharConn(){
        try{
            if(conn != null){
                conn.close();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao Fechar conexão" + e);
        }
    }    
}
