package app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.model.Cliente;
import app.view.ClienteFormulario;

public class ClienteController {
	
	private Cliente model;
	private ClienteFormulario view;
	
	public ClienteController(Cliente model, ClienteFormulario view) {
		this.model = model;
		this.view = view;
	}
	
	public void registerControls() {
		this.saveControl();
	}
	
	private void saveControl() {
		view.getBtnSalvar().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Recebe inputs da interface e atualiza o model
				model.setNome(view.getTfNome().getText());
				model.setTelefone(view.getTfTelefone().getText());
								
				//Se todos os inputs foram realizados de acordo com a regra de negócio
				if(model.validaCampos().isEmpty()){
					//Salva o Cliente (model)
					model.salva();
					
					//Atualiza a interface
					JOptionPane.showMessageDialog(view,
						    "Cliente " + model.getNome() + " salvo com sucesso!!!");
					
					view.getTfNome().setText("");
					view.getTfTelefone().setText("");
				}
				else{
					//Atualiza a interface
					JOptionPane.showMessageDialog(view,
						    "Preencha o(s) seguinte(s) campo(s):\n" + model.validaCampos(),
						    "ATENÇÃO",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}

}

