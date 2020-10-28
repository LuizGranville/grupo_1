package app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String telefone;
        private int id;
	
	public Cliente() {
		this.nome = "";
		this.telefone = "";
	}

	public Cliente(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}
        public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
        
	public Collection<String> validaCampos() {
		List<String> camposInvalidos = new ArrayList<String>();
		
		if(this.getNome().equals("")){
			camposInvalidos.add("Nome");
		}
		
		if(this.getTelefone().equals("")){
			camposInvalidos.add("Telefone");
		}
		
		return camposInvalidos;
	}
	
	public boolean salva(){
		//Persiste os dados numa base de dados
		return true;
	}
	
}
