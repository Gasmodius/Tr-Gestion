package Controlador;

import Modelo.*;
import Vista.PanelBiblioteca;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
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
            if(command.equals(vista.SALIR)){
            	JFrame ventana = new JFrame("Ventana Usuario");
            	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	ventana.setContentPane(vista);
            	ventana.pack();
            	ventana.setVisible(true);
                ventana.setLocationRelativeTo(null);
                Window w = SwingUtilities.getWindowAncestor(vista);
                w.dispose();
            }
            if(command.equals(vista.BORRAR)){
            	//comprobar que es administrador
            	vista.getLibros().borrarLibro();
            	JOptionPane.showMessageDialog(null, "Libro borrado");
            }
            if(command.equals(vista.INSERT)){
            	//comprobar que es administrador
            	Libro l = new Libro(vista.getTitulo(), vista.getAutor(), vista.getMaterias().getNombre());//hace falta comprobar que hay materias seleccionadas y cosas
            	JOptionPane.showMessageDialog(null, "Libro introducido");
            }
            if(command.equals(vista.ACTUALIZAR)){
            	//comprobar que es administrador
            }
            
            
         }catch(Error err){
            //vista.mensaje(err.getMessage());
        }
     
     }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        
        JList lista = (JList) e.getSource();
        Object o= lista.getSelectedValue();
        
        if(o instanceof Materia){
            Materia m= (Materia)o;
            vista.MostrarLibros(Libro.ListaLibrosMateria(m.getID()));
            
        }else if(o instanceof Libro){
            Libro l=(Libro)o;
            vista.setTitulo(l.getTitulo());
            vista.setAutor(l.getAutor());
        }
    }
    
}
