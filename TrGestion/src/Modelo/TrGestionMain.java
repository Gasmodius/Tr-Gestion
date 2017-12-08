package Modelo;

import javax.swing.JFrame;
import Controlador.*;
import Vista.*;

public class TrGestionMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PanelUsuarios vista = new PanelUsuarios();
        CtrlPanelUsuarios ctr = new CtrlPanelUsuarios(vista);		
	vista.controlador(ctr);
		
	JFrame ventana = new JFrame("Ventana Usuario");
	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ventana.setContentPane(vista);
	ventana.pack();
	ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);//se centra en la pantalla =D
    }
    
}
