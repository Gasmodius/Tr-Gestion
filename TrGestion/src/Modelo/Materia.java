package Modelo;

import java.util.ArrayList;
import java.util.List;


public class Materia {
//----- VARIABLES
	private String ID_Materia;
	private String Nombre;
//----- CONSTRUCTORES
	
	public Materia(String materiaName) {
		//CREA EL OBJETO A PARTIR DEL NOMBRE Y SUMANDO 1 AL ID MAS ALTO QUE RECUPERA DE LA BD (+= INCREMENTA EL INDICE INCREMENTANDO EL VALOR ASCII)
		BD miBD = new BD();
		miBD.Insert("INSERT INTO tMateria VALUES ( '"+materiaName+"' );");
		ID_Materia += ((String)miBD.SelectEscalar("SELECT MAX(ID_Materia) FROM tMateria;"));
		Nombre = materiaName;
		
	}
//------- METODOS
	public static String ID_Materia(String materia) {
		//DADO UN NOMBRE DEVUELVE SU ID, SI NO ESTO LO CREA
		BD miBD = new BD();
		
		String id= null;
		//POR SI HAY VARIOS CON EL MISMO NOMBRE, SE QUEDA CON EL ULTIMO ID
		for(Object[] tupla: miBD.Select("SELECT ID_Materia FROM tLibro WHERE NOMBRE = '"+materia+"' ;"))
		{
			id = ( (String)tupla[0] );
		}
		//SI LA CONSULTA NO LO ENCUENTRA CREA EL OBJETO A PARTIR DEL NOMBRE
		if(id == null) {
                    
			Materia mat = new Materia(materia);
                        id = mat.getID();
                   
		}
			
		return id;
	}
	public static List<Materia> listaMaterias(){
            //DEVUELVE UNA LISTA CON TODAS LAS MATERIAS DE LA BASE DE DATOS
            
            ArrayList<Materia> lista = new ArrayList<>();
            BD miBD = new BD();
            for(Object[] tupla: miBD.Select("SELECT ID_Materia FROM tMateria")){
                lista.add(new Materia((String)tupla[0]));
            }
        return lista;
        }
        
        public void actualizarNombreMateria(String materiaName){
            //ACTUALIZA EL NOMBRE DE UNA MATERIA EN LA BD Y EN EL OBJETO
            BD miBD = new BD();
            miBD.Update("UPDATE tMateria SET NOMBRE = '"+materiaName+"' WHERE NOMBRE = "+this.Nombre+");");
            this.Nombre = materiaName;
        }
        
        public String getNombre() {
            return Nombre;
        }

	public String getID() {
            return this.ID_Materia;
	}

}
