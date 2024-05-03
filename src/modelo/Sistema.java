package modelo;

import java.util.ArrayList;

public class Sistema {
	
	public static Sistema instance = null;
	private ArrayList<Cliente> listaClientes=new ArrayList<Cliente>();
	private ArrayList<Chofer> listaChoferes=new ArrayList<Chofer>();
	private ArrayList<Vehiculo> listaVehiculo=new ArrayList<Vehiculo>();
	private ArrayList<Viaje> listaViajes=new ArrayList<Viaje>();
	
	private Sistema() {
	}
	
	public static Sistema getInstance() {
		if(instance==null) {
			Sistema.instance = new Sistema();
		}
		return instance;
	}
	
}
