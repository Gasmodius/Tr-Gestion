package Controlador;

import Modelo.Usuario;
import Vista.PanelBiblioteca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class CtrPanelBiblioteca implements ActionListener,ListSelectionListener {
    
        private Usuario user;
	private PanelBiblioteca vista;
        
	public CtrPanelBiblioteca(PanelBiblioteca vista,Usuario u){
            user=u;
            this.vista = vista;
	}

	public void actionPerformed(ActionEvent e){
         try{ 
            String command=e.getActionCommand();
            if(command.equals("  ")){

            }
         }catch(Error err){
            //vista.mensaje(err.getMessage());
        }
     
     }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        JList lista = (JList) e.getSource();
	
    }
    
}
