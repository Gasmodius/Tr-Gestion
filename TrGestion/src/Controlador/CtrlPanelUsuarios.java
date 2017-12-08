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
                
               
                usu=new Usuario(vista.getUser(), vista.getPwd());
                vista.mensaje("Usuario Identificado");
                if(usu.getRol().Modificacion("USUARIOS")){
                    CtrLista ctrLista = new CtrLista(usu);
                    
                    
                }
            }
         }catch(Error err){
             vista.mensaje(err.getMessage());
             usu=null;
        }
     
     }
}
