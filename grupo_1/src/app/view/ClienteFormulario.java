package app.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ClienteFormulario extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JLabel lbNome;
	private JTextField tfNome;
	
	private JLabel lbTelefone;
	private JTextField tfTelefone;
	
	private JButton btnSalvar;


	/**
	 * Create the frame.
	 */
	public ClienteFormulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel formPanel = new JPanel();
		contentPane.add(formPanel, BorderLayout.CENTER);
		formPanel.setLayout(new GridLayout(4, 1));
		
		formPanel.add(this.getLbNome());		
		formPanel.add(this.getTfNome());
		
		formPanel.add(this.getLbTelefone());		
		formPanel.add(this.getTfTelefone());
		
		JPanel commandPanel = new JPanel();
		contentPane.add(commandPanel, BorderLayout.SOUTH);
		
		commandPanel.add(this.getBtnSalvar());
	}
	
	public JLabel getLbNome() {
		if(lbNome == null) {
			lbNome = new JLabel("Nome:");
		}
		
		return lbNome;
	}
	
	public JTextField getTfNome() {
		if(tfNome == null) {
			tfNome = new JTextField(20);
		}
		
		return tfNome;
	}
	
	public JLabel getLbTelefone() {
		if(lbTelefone == null) {
			lbTelefone = new JLabel("Telefone:");
		}
		
		return lbTelefone;
	}
	
	public JTextField getTfTelefone() {
		if(tfTelefone == null) {
			tfTelefone = new JTextField(20);
		}
		
		return tfTelefone;
	}
	
	public JButton getBtnSalvar() {
		if(btnSalvar == null) {
			btnSalvar = new JButton("SALVAR");
		}
		
		return btnSalvar;
	}

}
