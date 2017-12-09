package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Libro {
//-----VARIABLES	
	private  int ID;
	private String titulo;
	private String autor;
	private String ID_Materia;
//------CONSTRUCTORES	
	public Libro(String tit, String aut, String materiaName){
		BD miBD = new BD();
		
		String idm = Materia.ID_Materia(materiaName);
		titulo = tit;
		autor = aut;
		ID= ((Integer)miBD.SelectEscalar("SELECT MAX(ID) FROM tLibro;"))+1;
		ID_Materia = idm;
                miBD.Insert("INSERT INTO tLibro VALUES ("+ID+",'"+tit+"',  '"+aut+"', '"+materiaName+"' );");
	}
	
	public Libro(int id) {
		BD miBD = new BD();
		Object [] tupla = miBD.Select("SELECT * FROM tLibro WHERE ID = "+id+";").get(0);
		
		ID = (Integer) tupla[0];
		titulo = (String) tupla[1];
		autor = (String) tupla[2];
		ID_Materia= (String) tupla[3];
	}
//------METODOS
	public static List<Libro> ListaLibros(){
		ArrayList<Libro> lista = new ArrayList<Libro>();
		BD miBD = new BD();
		
		for(Object[] tupla : miBD.Select("SELECT ID FROM tLibro ;")) {
			
			lista.add(new Libro( (Integer) tupla[0] ) );
		}
		return lista;
	}
	public static List<Libro> ListaLibrosMateria(String idMateria){
		ArrayList<Libro> lista = new ArrayList<Libro>();
		BD miBD = new BD();
		
		for(Object[] tupla : miBD.Select("SELECT ID FROM tLibro WHERE ID_Materia = '"+idMateria+"' ;")) {
			
                    lista.add(new Libro( (Integer) tupla[0] ) );
		}
		return lista;
	}
        
        public void borrarLibro(int idLibro){
            BD miBD = new BD();
            miBD.Delete("DELETE FROM tlibro WHERE ID ="+ idLibro + ";");
            this.ID = -1;
            this.autor = null;
            this.ID_Materia = null;
            this.titulo = null;
            
        }
//----- getters y setters

	public int getID() {
		return ID;
	}

	public void setID(int value) {

		BD miBD = new BD();
    	miBD.Update("UPDATE tLibro SET ID = '" + value 
    			+ "' WHERE ID = "+ this.ID + ";");
    	
    	ID = value;  
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String value) {
		BD miBD = new BD();
    	miBD.Update("UPDATE tLibro SET TITULO = '" + value 
    			+ "' WHERE ID = '"+ this.ID + "';");
    	
    	titulo = value;  
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String value) {
		BD miBD = new BD();
    	miBD.Update("UPDATE tLibro SET AUTOR = '" + value 
    			+ "' WHERE ID = '"+ this.ID + "';");
    	
    	autor = value;  
	}

	public String getID_Materia() {
		return ID_Materia;
	}

	public void setID_Materia(String value) {
		BD miBD = new BD();
    	miBD.Update("UPDATE tLibro SET AUTOR = '" + value 
    			+ "' WHERE iD_Materia = '"+ this.ID + "';");
    	
    	ID_Materia = value;  
	}
	
	public String toString(){return this.titulo;}
	
}
