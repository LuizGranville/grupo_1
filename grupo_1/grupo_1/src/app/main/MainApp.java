package app.main;

import app.controller.ClienteController;
import app.model.Cliente;
import app.view.ViewPrincipal;

public class MainApp {

	public static void main(String[] args) {
            
            
		Cliente model = new Cliente();
		ViewPrincipal view = new ViewPrincipal();
		ClienteController controller = new ClienteController();
		
		view.pack();
		view.setVisible(true);
				
	}

}