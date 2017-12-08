package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.*;
import Modelo.*;

public class CtrlPanelUsuarios implements ActionListener{
	private PanelUsuarios vista;
        private Usuario usu;
        

	public CtrlPanelUsuarios(PanelUsuarios vista){
		this.vista = vista;
	}

	public void actionPerformed(ActionEvent e){
         try{ 
            String command=e.getActionCommand();
            if(command.equals(vista.LOGIN)){
                vista.limpiar();
                vista.desactivaBotones();
                usu=new Usuario(vista.getUser(), vista.getPwd());
                vista.mensaje("Usuario Identificado");
                
                if(usu.getRol().Acceso("USUARIOS")){
                    vista.ActivarUsuarios();
                }
                if(usu.getRol().Modificacion("USUARIOS")){
                    CtrLista ctrLista = new CtrLista(usu);
                    vista.controladorLista(ctrLista);
                    
                }
            }else if(command.equals(vista.USUARIOS)){
                vista.limpiar();
                vista.MostrarUsuarios(usu.ListaUsuarios());
            }
         }catch(Error err){
             vista.mensaje(err.getMessage());
             usu=null;
        }
     
     }
}
