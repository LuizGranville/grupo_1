package app.main;

import app.controller.ClienteController;
import app.model.Cliente;
import app.view.ClienteFormulario;

public class MainApp {

	public static void main(String[] args) {
		Cliente model = new Cliente();
		ClienteFormulario view = new ClienteFormulario();
		ClienteController controller = new ClienteController(model, view);
		controller.registerControls();
		
		view.pack();
		view.setVisible(true);
				
	}

}