package Vista;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBiblioteca extends JPanel {
    
    private JButton Binsertar,Bborrar,Bactualizar,Bsalir;
    
    public PanelBiblioteca(){
        setLayout(new BorderLayout());
        Binsertar=new JButton("Insertar");
        add(Binsertar,BorderLayout.SOUTH);
    }
    
    public void controlador(ActionListener ctrl) {
	
    }
}
