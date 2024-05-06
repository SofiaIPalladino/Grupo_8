package org.grupo8.puntajes;


import org.grupo8.chofer.Chofer;
import org.grupo8.sistema.Empresa;
import org.grupo8.usuario.Usuario;

import java.util.List;

public class GestionPuntajes {
	
    public void actualizarPuntajes(Usuario usuario) {
    	if (usuario.isAdmin()) {
    		Chofer chofermax=null;
    		double maxDistancia = 0;
    		Empresa empresa=Empresa.getInstance();
    		List<Chofer> choferes=empresa.getChoferes();
    		for (int i = 0; i <  choferes.size(); i++) {
    			Chofer c=choferes.get(i);
    			c.agregaPuntaje(c.cantViajes()*5);
    			if (c.getKm() > maxDistancia) {
    				maxDistancia = c.getKm();
    				chofermax=c;
                
    			}
    		}
    		if (chofermax!=null)
    			chofermax.agregaPuntaje(15);
    	}else 
    		System.out.println("Solo el administrador puede actualizar los puntajes");	  	
    }
    
    public void MuestraPuntajes(Usuario usuario) {
    	if (usuario.isAdmin()) {
    		Empresa empresa=Empresa.getInstance();
    		List<Chofer> choferes=empresa.getChoferes();
    		System.out.println("Listado de puntajes: ");
    		for (int i=0;i<choferes.size();i++) {
    			Chofer c=choferes.get(i);
    			System.out.println(c.getNombre()+" con DNI "+c.getDni()+": "+c.getPuntaje());
    		}
    		System.out.println("--------------------------------------");
    	}else
    		System.out.println("Solo el administrador puede actualizar los puntajes");	 	
    }
    
}

