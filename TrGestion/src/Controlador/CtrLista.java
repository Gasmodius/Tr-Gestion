package Controlador;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Vista.*;
import Modelo.*;

public class CtrLista implements ListSelectionListener {

	private Usuario user;
        private PanelBiblioteca panelbiblio;
	
	public CtrLista(Usuario u)
	{
		super();
		user = u;
                panelbiblio=null;

	}
	public void valueChanged(ListSelectionEvent e){
                if (panelbiblio==null)
		{
			JList lista = (JList) e.getSource();
			Object o = lista.getSelectedValue();
			if (o.getClass().equals(Usuario.class))
			{
				Usuario u = (Usuario)o;
				JFrame ventana = new JFrame("Usuario");
				panelbiblio = new PanelBiblioteca();
				//panelbiblio.MostrarUsuarios(u);
				ventana.setContentPane(panelbiblio);
				ventana.pack();
				ventana.setVisible(true);
			}
		}
                
	}

}
