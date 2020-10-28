/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller.bd;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author lfggr
 */
public class Conexao {
    
    public void conecta(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd", "root", "root");
            JOptionPane.showMessageDialog(null, "Conectou!");
        }
        catch(ClassNotFoundException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar: \n" + erro);
        }
        
    }
    public void desconecta(){
        try{
            conexao.close();
            JOptionPane.showMessageDialog(null, "Desconectou!");
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Não foi possível fechar o Banco de Dados" + erro);
        }
        
    }
    
    public void querySQL(String sql){
        try{
            this.stm = conexao.createStatement();
            this.rst = stm.executeQuery(sql);
        } catch (SQLException sqlex){
            JOptionPane.showMessageDialog(null, "Não foi possível executar o comando SQL,\n" + sqlex + ",\no sql");
        }
    }
    public void instrucaoSQL(String pstm){
        try{
            this.pstm = conexao.prepareStatement(pstm);
        } catch (SQLException sqlex){
            JOptionPane.showMessageDialog(null, "Não foi possível executar o comando SQL,\n" + sqlex + ",\no sql");
        }
    }
    public void setPstm(int i, Object o){
        try{
            pstm.setObject(i, o);
        } catch (SQLException sqlex){
            JOptionPane.showMessageDialog(null, "Não foi possível executar o comando SQL,\n" + sqlex + ",\no sql");
        }
    }
    public PreparedStatement getPstm(){
        return this.pstm;
    }
    public ResultSet getResultSet(){
        return rst;
    }
    
    private Connection conexao;
    private PreparedStatement pstm;
    private Statement stm;
    private ResultSet rst;
    
}
