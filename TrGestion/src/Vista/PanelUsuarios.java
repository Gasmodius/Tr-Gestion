package Vista;

import java.awt.*;
import java.awt.event.*;
import Modelo.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;

public class PanelUsuarios extends JPanel{
	
        public final static String LOGIN = "LOGIN",USUARIOS = "USUARIOS";    
        private JTextField user;
	private JPasswordField pwd;
	private JList<Usuario> resultado;
	private JButton bLogin, bUsuarios;
	private JLabel pulsaciones;
	private DefaultListModel <Usuario>modeloLista;
	
	public PanelUsuarios() {
		setLayout(new BorderLayout());
		bLogin = new JButton(LOGIN);
		JLabel etiqLogin = new JLabel("Identificacion de Usuario");
		etiqLogin.setHorizontalAlignment(SwingConstants.CENTER);
		user = new JTextField(20);
		user.setBorder(new TitledBorder("Usuario:"));
		pwd = new JPasswordField(20);
		pwd.setBorder(new TitledBorder("Contraseña:"));
		resultado = new JList<Usuario>();
		modeloLista = new DefaultListModel<Usuario>();
		resultado.setModel(modeloLista);
		bUsuarios = new JButton(USUARIOS);


		JPanel panelSuperior = new JPanel();
		panelSuperior.setLayout(new GridLayout(2, 2));
		panelSuperior.add(etiqLogin);		
		panelSuperior.add(user);
		panelSuperior.add(bLogin);
		panelSuperior.add(pwd);
		add(panelSuperior, BorderLayout.NORTH);
		desactivaBotones();

	}
	public void controlador(ActionListener ctrl) {
		bLogin.addActionListener(ctrl);
		bLogin.setActionCommand(LOGIN);
		
		bUsuarios.addActionListener(ctrl);	
		bUsuarios.setActionCommand(USUARIOS);
	}
	
	public void controladorLista(ListSelectionListener ctrLista){
		resultado.addListSelectionListener(ctrLista);
	}


	public void MostrarUsuarios(java.util.List<Usuario> lista){
		for(Usuario u: lista)
		{
			modeloLista.addElement(u);
		}
	}

	public void limpiar() {
		modeloLista.clear();
	}

	public void mensaje(String msg) {
		// muestra un mensaje en azul
		pulsaciones.setForeground(Color.blue);
		pulsaciones.setText(msg);
	}

	public void alerta(String msg) {
		// muestra un mensaje en rojo
		pulsaciones.setForeground(Color.red);
		pulsaciones.setText(msg);
	}
	
	public String getUser(){
		return user.getText();
	}
	
	public String getPwd(){
		return new String(pwd.getPassword());
	}
	
	public void desactivaBotones(){
		bUsuarios.setVisible(false);
	}
	
	public void ActivarUsuarios(){
		bUsuarios.setVisible(true);
	}
}
