package pedido;

import chofer.Chofer;
import excepciones.NoChoferException;
import excepciones.NoVehiculoException;
import sistema.Empresa;
import vehiculo.Vehiculo;

import java.util.List;

public class GestionPedidos {
	
	Empresa empresa= Empresa.getInstance();
	
	public void evaluaPedido(Pedido p)  {
		List<Vehiculo> vehiculos=empresa.getVehiculos();
		Vehiculo v=null;
		try {
			buscarVehiculo(vehiculos,p.getCantPersonas(),p.usoBaul(),p.getMascota());
		} catch (NoVehiculoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		empresa.agregaPedido(p);					
	}
	
	
	public static boolean buscarVehiculo(List<Vehiculo> v,int cantPasajeros,boolean baul,boolean mascota ) throws NoVehiculoException {
        int i = 0;
        Vehiculo p=null;
        while (i < v.size()) {
        	p= v.get(i);
            if (p.verificaPasajeros(cantPasajeros) && p.verificaBaul(baul)&& p.verificaMascota(mascota)) {
                return true; // Retorna la instancia de la persona encontrada
            }
            i++;
        }
    	throw new NoVehiculoException("No existe vehiculo que cumpla con esas caracteristicas");
    }
	//no se usa por ahora
	public static Chofer buscarChofer(List<Chofer> c) throws NoChoferException {
        int i = 0;
        Chofer p=null;
        while (i < c.size()) {
        	p = c.get(i);
        	return p;//para en un futuro tener que elegier un chofer por x caracteristica
            }
            i++;
        
            throw new NoChoferException("NO existe un chofer disponible");
    }
	

}