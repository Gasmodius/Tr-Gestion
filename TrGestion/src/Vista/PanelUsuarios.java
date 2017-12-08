package Vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelUsuarios extends JPanel{
	
        public final static String LOGIN = "LOGIN",USUARIOS = "USUARIOS";    
        private JTextField user;
	private JPasswordField pwd;
	private JButton bLogin;
	private JLabel textplace;
	
	public PanelUsuarios() {
		setLayout(new BorderLayout());
		bLogin = new JButton("Entrar");
		JLabel etiqLogin = new JLabel("Identifica el Usuario");
		etiqLogin.setHorizontalAlignment(SwingConstants.CENTER);
		user = new JTextField(20);
		user.setBorder(new TitledBorder("Usuario:"));
		pwd = new JPasswordField(20);
		pwd.setBorder(new TitledBorder("Contraseña:"));


		JPanel panelSuperior = new JPanel();
		panelSuperior.setLayout(new GridLayout(2, 2));
		panelSuperior.add(etiqLogin);		
		panelSuperior.add(user);
		panelSuperior.add(bLogin);
		panelSuperior.add(pwd);
		add(panelSuperior, BorderLayout.NORTH);
                
                textplace = new JLabel("");
		textplace.setHorizontalAlignment(SwingConstants.RIGHT);
                add(textplace,BorderLayout.SOUTH);

	}
	public void controlador(ActionListener ctrl) {
		bLogin.addActionListener(ctrl);
		bLogin.setActionCommand(LOGIN);
	}

	public void mensaje(String msg) {
		// muestra un mensaje en azul
		textplace.setForeground(Color.blue);
		textplace.setText(msg);
	}

	public void alerta(String msg) {
		// muestra un mensaje en rojo
		textplace.setForeground(Color.red);
		textplace.setText(msg);
	}
	
	public String getUser(){
		return user.getText();
	}
	
	public String getPwd(){
		return new String(pwd.getPassword());
	}
}
