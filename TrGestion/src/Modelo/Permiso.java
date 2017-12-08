package Modelo;

import java.util.*;


public class Permiso {
    
	private String rolName;
	private String pantalla;
    private boolean acceso;
    private boolean modificacion;


    public static List<Permiso> ListaPermisosRol(String rolName)
    {

		ArrayList<Permiso> lista = new ArrayList<Permiso>(); 		
		// Retorna una lista con todos los obejtos de la clase almacenados en la base de datos
		BD miBD = new BD();
		
		for(Object[] tupla: miBD.Select("SELECT pantalla FROM tPermiso WHERE rolName = '" + rolName + "';"))
		{
			lista.add(new Permiso(rolName, (String)tupla[0]));
		}
		return lista;
    }
    
    public Permiso(String r, String p)
    {
		// Crea el objeto cargando sus valores de la base de datos
    	BD miBD = new BD();
		
    	Object[] tupla = miBD.Select("SELECT * FROM tPermiso WHERE " 
    			+ "rolName = '" + r + "' AND "
    			+ "pantalla= '" + p + "';").get(0);
    	

    	rolName = (String)tupla[0];
    	pantalla  = (String)tupla[1];
        acceso = (Boolean)tupla[2];
        modificacion = (Boolean)tupla[3];
    }

    public Permiso(String r, String p, boolean a, boolean m)
    {
		// Crea el objeto y lo inserta en la base de datos
    	BD miBD = new BD();
		
    	miBD.Insert("INSERT INTO tPermiso VALUES(' " + r + "'," 
    			+ "'" + p + "', " + (a?1:0) + ", " + (m?1:0) + ");");
    	
    	rolName = r;
    	pantalla  = p;
        acceso = a;
        modificacion = m;

    }
    
	public void setRolName(String value) 
	{
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD();
    	miBD.Update("UPDATE tPermiso SET rolName = '" + value + "' WHERE " 
    			+ "rolName = '" + rolName + "' AND "
    			+ "pantalla= '" + pantalla + "';");
    	
    	rolName = value;
	}

	public String getRolName() 
	{
		return rolName;
	}
    
    public String getPantalla() 
    {
    	return pantalla; 
    }
    
    public void setPantalla(String value) 
    {
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD();
    	miBD.Update("UPDATE tPermiso SET pantalla = '" + value + "' WHERE " 
    			+ "rolName = '" + rolName + "' AND "
    			+ "pantalla= '" + pantalla + "';");
    	
    	pantalla = value;
    }
    

    public boolean getAcceso() 
    { 
    	return acceso; 
    }
        
    public void setAcceso(boolean value) 
    { 
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD();
    	miBD.Update("UPDATE tPermiso SET acceso = " + (value?1:0) + " WHERE " 
    			+ "rolName = '" + rolName + "' AND "
    			+ "pantalla= '" + pantalla + "';");
    	
    	acceso = value;
    }

    
    public boolean getModificacion() 
    { 
    	return modificacion; 
    }
    
    public void setModificacion(boolean value) 
    { 
		// Actualiza el atributo en memoria y en la base de datos
    	BD miBD = new BD();
    	miBD.Update("UPDATE tPermiso SET modificacion = " + (value?1:0) + " WHERE " 
    			+ "rolName = '" + rolName + "' AND "
    			+ "pantalla= '" + pantalla + "';");
    	
    	modificacion = value;
    }


}
