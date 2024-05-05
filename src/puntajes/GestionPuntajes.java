package puntajes;

import sistema.Empresa;
import usuario.Usuario;
import chofer.Chofer;
import java.util.List;

public class GestionPuntajes {
    public static void actualizarPuntajes(Usuario usuario) {
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
}
