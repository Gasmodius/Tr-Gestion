package Controlador;

import Modelo.*;
import Vista.PanelBiblioteca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class CtrPanelBiblioteca implements ActionListener,ListSelectionListener {
    
        private Usuario user;
	private PanelBiblioteca vista;
        private boolean libroselect;
        
	public CtrPanelBiblioteca(PanelBiblioteca vista,Usuario u){
            user=u;
            this.vista = vista;
            libroselect=false;
	}
        

	public void actionPerformed(ActionEvent e){
         try{ 
            String command=e.getActionCommand();
            if(command.equals(vista.SALIR)){
                System.exit(0);
                
            }else if(command.equals(vista.LIMPIAR)){
            	vista.setAutor("");
                vista.setTitulo("");
                libroselect=false;
                //Deseleccionar los libros--------------------------
                
            }else if(user.getRol().getAdmin()){
                if(libroselect){
                if(command.equals(vista.BORRAR)){
            	vista.getLibro().borrarLibro();
                vista.MostrarLibros(Libro.ListaLibrosMateria(Materia.ID_Materia(vista.getMateria().getNombre())));
            	JOptionPane.showMessageDialog(null, "Libro borrado");
                
                }else if(command.equals(vista.INSERT)){
            	Libro l = new Libro(vista.getTitulo(), vista.getAutor(), vista.getMateria().getNombre());
            	vista.MostrarLibros(Libro.ListaLibrosMateria(Materia.ID_Materia(vista.getMateria().getNombre())));
                JOptionPane.showMessageDialog(null, "Libro introducido");
                
                }else if(command.equals(vista.ACTUALIZAR)){
            	vista.getLibro().setTitulo(vista.getTitulo());
                vista.getLibro().setAutor(vista.getAutor());
            	vista.MostrarLibros(Libro.ListaLibrosMateria(Materia.ID_Materia(vista.getMateria().getNombre())));
                JOptionPane.showMessageDialog(null, "Libro Modificado");  
                }
                
            }else{JOptionPane.showMessageDialog(null,"No has seleccionado ningun libro");}
            }else{JOptionPane.showMessageDialog(null,"No tienes permiso para hacer esa accion");}
            
         }catch(Error err){
            JOptionPane.showMessageDialog(null, err.getMessage());
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
            libroselect=true;
        }
    }
    
}
