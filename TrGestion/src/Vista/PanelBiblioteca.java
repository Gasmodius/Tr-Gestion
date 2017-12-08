package Vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelBiblioteca extends JPanel {
    
    public final static String INSERT="INSERT",BORRAR="BORRAR",ACTUALIZAR="ACTUALIZAS",SALIR="SALIR";
    private JButton Binsertar,Bborrar,Bactualizar,Bsalir;
    private JTextField TFtitulo,TFautor;
    
    public PanelBiblioteca(){
        
        Binsertar=new JButton("Insertar");
        Bborrar=new JButton("Borrar");
        Bactualizar=new JButton("Actualizar");
        Bsalir=new JButton("Salir");
        TFtitulo=new JTextField(20);
        TFtitulo.setBorder(new TitledBorder("Titulo:"));
        TFautor=new JTextField(20);
        TFautor.setBorder(new TitledBorder("Autor:"));
        
        //---------Contruccion de la Ventana-----------
        setLayout(new BorderLayout());
        
        JPanel panelnorte=new JPanel();
        add(panelnorte,BorderLayout.NORTH);
        
        JPanel panelnorteArriba=new JPanel();
        //----------
        panelnorte.add(panelnorteArriba,BorderLayout.NORTH);
        
        JPanel panelnorteAbajo =new JPanel();
        //------------
        panelnorte.add(panelnorteAbajo,BorderLayout.SOUTH);
        
        //-----------Paneles de la parte SUR-------------
        JPanel panelsur=new JPanel();
        panelsur.setLayout(new BorderLayout());
        add(panelsur,BorderLayout.SOUTH);
        
        JPanel panelsurArriba=new JPanel();
        panelsurArriba.setLayout(new GridLayout(1,1));
        panelsurArriba.add(TFtitulo);
        panelsurArriba.add(TFautor);
        panelsur.add(panelsurArriba,BorderLayout.NORTH);
        
        JPanel panelsurAbajo =new JPanel();
        panelsurArriba.setLayout(new GridLayout(4,1));
        panelsurAbajo.add(Binsertar);
        panelsurAbajo.add(Bborrar);
        panelsurAbajo.add(Bactualizar);
        panelsurAbajo.add(Bsalir);
        panelsur.add(panelsurAbajo,BorderLayout.SOUTH);   
    }
    
    public void controlador(ActionListener ctrl) {
	Binsertar.addActionListener(ctrl);
	Binsertar.setActionCommand(INSERT);
        Bborrar.addActionListener(ctrl);
	Bborrar.setActionCommand(BORRAR);
        Bactualizar.addActionListener(ctrl);
	Bactualizar.setActionCommand(ACTUALIZAR);
        Bsalir.addActionListener(ctrl);
	Bsalir.setActionCommand(SALIR);
    }
}
