package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import app.model.Cliente;
import app.controller.bd.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClienteController {
	
	private Cliente model;
	
	//public ClienteController(Cliente model) {
		//this.model = model;
	
	//}
	
        
        public int grava(Cliente m){
            int id = 0;
            con = new Conexao();
            con.conecta();
            con.instrucaoSQL("INSERT INTO dados_mvc(nome, telefone) VALUES (?,?)");
            con.setPstm(1, m.getNome());
            con.setPstm(2, m.getTelefone());
            try{
                con.getPstm().execute();
                JOptionPane.showMessageDialog(null, "Usuário Gravado com sucesso!");
                con.querySQL("SELECT MAX(id) FROM dados_mvc");
                if (con.getResultSet().next()==true ){
                    id = con.getResultSet().getInt("MAX(id)");
                }
                con.desconecta();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex, "Erro ao tentar gravar\n" + ex, 1);
            }
            return id;
             
        }
        
        public void lista(){
            Cliente m;
            con = new Conexao();
            con.conecta();
            con.querySQL("SELECT * FROM dados_mvc");
            
            try{
                while (con.getResultSet().next()){
                    m = new  Cliente();
                    m.setId(con.getResultSet().getInt("id"));
                    m.setNome(con.getResultSet().getString("nome"));
                    m.setTelefone(con.getResultSet().getString("telefone"));
                    lc.add(m);
                }
                con.desconecta();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex, "Erro ao tentar listar\n" + ex, 1);
            }
            
        }
        
        public void imprimeLista(){
            lista();
            System.out.println("Dados constados na lista:");
            int c = 0;
            while (c < lc.size()){
                System.out.println("Identificador: "+lc.get(c).getId() +
                        "\tNome: " + lc.get(c).getNome() +
                        "\tNome: " + lc.get(c).getTelefone());
               c++;
            }
        }
        
        private final List<Cliente> lc = new ArrayList();
        private Conexao con = null;

}

