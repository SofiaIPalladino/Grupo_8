package usuario;

import java.util.List;

import chofer.Chofer;
import vehiculo.Vehiculo;
import viaje.Viaje;

public class Empresa {
	private static Empresa instance=null;
	private List<Cliente> clientes;
	private List<Chofer> choferes;
	private List<Vehiculo> vehiculos;
	private List<Viaje> viajes;
	
	private Empresa() { 
	}
	
	public static Empresa getInstance() {
		if (instance==null) 
			instance=new Empresa();
		return instance;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public List<Chofer> getChoferes() {
		return choferes;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public List<Viaje> getViajes() {
		return viajes;
	}
	
	
	
}
	
	