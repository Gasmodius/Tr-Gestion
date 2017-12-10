package Vista;

import Modelo.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;

public class PanelBiblioteca extends JPanel {
    
    public final static String INSERT="INSERT",BORRAR="BORRAR",ACTUALIZAR="ACTUALIZAS",SALIR="SALIR",LIMPIAR="LIMPIAR";
    private JButton Binsertar,Bborrar,Bactualizar,Bsalir,Blimpiar;
    private JTextField TFtitulo,TFautor;
    private JList<Libro> libros;
    private DefaultListModel <Libro>modeloListaLibros;
    private JList<Materia> materias;
    private DefaultListModel <Materia>modeloListaMaterias;
    
    public PanelBiblioteca(){
        
        Binsertar=new JButton("Insertar");
        Bborrar=new JButton("Borrar");
        Bactualizar=new JButton("Actualizar");
        Bsalir=new JButton("Salir");
        Blimpiar=new JButton("Limpiar");
        TFtitulo=new JTextField(20);
        TFtitulo.setBorder(new TitledBorder("Titulo:"));
        TFautor=new JTextField(20);
        TFautor.setBorder(new TitledBorder("Autor:"));
        
        materias = new JList<Materia>();
	modeloListaMaterias = new DefaultListModel<Materia>();
	materias.setModel(modeloListaMaterias);
        MostrarMaterias(Materia.listaMaterias());
        
        libros = new JList<Libro>();
	modeloListaLibros = new DefaultListModel<Libro>();
	libros.setModel(modeloListaLibros);
        
        //---------Contruccion de la Ventana-----------
        setLayout(new BorderLayout());
        
        //-----------Paneles de la parte NORTE-------------
        JPanel panelnorte=new JPanel();
        add(panelnorte,BorderLayout.NORTH);
        
        panelnorte.add(new JLabel("Materia"),BorderLayout.WEST);
        JScrollPane paneldeMaterias = new JScrollPane(materias);
        panelnorte.add(paneldeMaterias,BorderLayout.EAST);
        
        
        JScrollPane panelnorteAbajo = new JScrollPane(libros);
        add(panelnorteAbajo,BorderLayout.CENTER);
        
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
        panelsurArriba.setLayout(new GridLayout(5,1));
        panelsurAbajo.add(Binsertar);
        panelsurAbajo.add(Bborrar);
        panelsurAbajo.add(Bactualizar);
        panelsurAbajo.add(Blimpiar);
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
        Blimpiar.addActionListener(ctrl);
	Blimpiar.setActionCommand(LIMPIAR);
        
        libros.addListSelectionListener((ListSelectionListener) ctrl);
        materias.addListSelectionListener((ListSelectionListener) ctrl);
    }
    
    public void MostrarMaterias(List<Materia> lista){
	for(Materia u: lista){
            modeloListaMaterias.addElement(u);
	}
    }

    public void limpiarLibros() {
        try{
	modeloListaLibros.get(-1);
        }catch(IndexOutOfBoundsException er){}
    }
    
    public void MostrarLibros(List<Libro> lista){
	modeloListaLibros.clear();
        for(Libro u: lista){
            modeloListaLibros.addElement(u);
	}
    }
    
    public void setTitulo(String i){
        TFtitulo.setText(i);
    }
    
    public String getTitulo(){
        return TFtitulo.getText();
    }
    
    public void setAutor(String i){
        TFautor.setText(i);
    }

    public String getAutor(){
        return TFautor.getText();
    }
    
    public Materia getMateria() {
	return materias.getSelectedValue();
    }

    public void setMaterias(JList<Materia> materias) {
	this.materias = materias;
    }



    public Libro getLibro() {
        return libros.getSelectedValue();
    }



    public void setLibros(JList<Libro> libros) {
	this.libros = libros;
    }
	
	
}
