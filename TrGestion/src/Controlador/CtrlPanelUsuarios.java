package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.*;
import Modelo.*;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class CtrlPanelUsuarios implements ActionListener{
    
	private PanelUsuarios vista;
        
	public CtrlPanelUsuarios(PanelUsuarios vista){
		this.vista = vista;
	}

	public void actionPerformed(ActionEvent e){
         try{ 
            String command=e.getActionCommand();
            if(command.equals(vista.LOGIN)){

                Usuario usu=new Usuario(vista.getUser(), vista.getPwd());
                vista.mensaje("Usuario Identificado");
                
                PanelBiblioteca Vistabiblio = new PanelBiblioteca();
                CtrPanelBiblioteca ctr = new CtrPanelBiblioteca(Vistabiblio,usu);		
                Vistabiblio.controlador(ctr);
		
                JFrame marcoBiblio = new JFrame("Ventana Usuario");
                marcoBiblio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                marcoBiblio.setContentPane(Vistabiblio);
                marcoBiblio.pack();
                marcoBiblio.setVisible(true);
                marcoBiblio.setLocationRelativeTo(null);//se centra en la pantalla =D
                
                //Coge el JFrame de la vista y lo hace invisible(Que no esta borrado ojo)
                Window w = SwingUtilities.getWindowAncestor(vista);
                w.setVisible(false);
                
            }
         }catch(Error err){
             vista.mensaje(err.getMessage());
        }
     
     }
}
