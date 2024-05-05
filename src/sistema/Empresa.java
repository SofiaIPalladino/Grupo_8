package sistema;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import chofer.Chofer;
import excepciones.NoChoferException;
import excepciones.NoVehiculoException;
import pedido.Pedido;
import usuario.Cliente;
import usuario.Usuario;
import vehiculo.Vehiculo;
import viaje.IViaje;
import viaje.Viaje;

public class Empresa {
	private static Empresa instance=null;
	private List<Cliente> clientes;
	private List<Usuario> usuarios;
	
////Cambniar esto por un hash map donde en la primera posicion este el chofer y en la segunda este si esta disponible o no
	private List<Chofer> choferes;
	private List<Chofer> choferesDisponibles;
	private List<Chofer> choferesEnUso;
	///*******************************************//
	

	////Cambniar esto por un hash map donde en la primera posicion este el vehiculo y en la segunda este si esta disponible o no
	private List<Vehiculo> vehiculos;
	private List<Vehiculo> vehiculosDisponibles;
	private List<Vehiculo> vehiculosEnUso;
	
	
	///*******************************************//
	
	private List<IViaje> viajes;
	private List<IViaje> viajesFinalizados;
	private List<Pedido> pedidos;
	private double recaudado = 0;

	
	private Empresa() { 
		vehiculosEnUso = new ArrayList<Vehiculo>();
		vehiculos = new ArrayList<Vehiculo>();
		choferes = new ArrayList<Chofer>();
		choferesEnUso = new ArrayList<Chofer>();
		clientes = new ArrayList<Cliente>();
		usuarios = new ArrayList<Usuario>();
		pedidos= new ArrayList<Pedido>();
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
	
	public List<Chofer> getChoferesEnUso() {
		return choferesEnUso;
	}
	
	
	public List<Chofer> getChoferesDisponibles() {
		return choferesDisponibles;
	}

	public List<Vehiculo> getVehiculosDisponibles() {
		return vehiculosDisponibles;
	}

	public List<IViaje> getViajesFinalizados() {
		return new ArrayList<IViaje>(viajesFinalizados);
	}
	
	public List<IViaje> getViajes(Chofer chofer){
		List<IViaje> viajesChofer = new ArrayList<IViaje>();
		for (IViaje viaje: viajesFinalizados) {
			if (viaje.getChofer() == chofer) {
				viajesChofer.add(viaje);
			}
		}
		return viajesChofer;
	}
	
	public List<IViaje> getViajes(Cliente cliente){
		List<IViaje> viajesChofer = new ArrayList<IViaje>();
		for (IViaje viaje: viajesFinalizados) {
			if (viaje.getCliente() == cliente) {
				viajesChofer.add(viaje);
			}
		}
		return viajesChofer;
	}

	public List<Vehiculo> getVehiculosEnUso() {
		return vehiculosEnUso;
	}

	public List<IViaje> getViajes() {
		return viajes;
	}

	public double getRecaudado() {
		return recaudado;
	}

	public void sumaRecaudado(double monto) {
		this.recaudado += monto;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setChoferConViaje(Chofer c) throws NoChoferException {
		this.choferesEnUso.add(c);
	}
	public void setChoferDisponible(Chofer c) throws NoChoferException {
		if (!choferesEnUso.remove(c))
			throw new NoChoferException("El chofer seleccionado no esta en uso");
		this.choferes.add(c);
	}
	
	
	public void setVehiculoConViaje(Vehiculo v) throws NoVehiculoException  {
		this.vehiculosEnUso.add(v);
	}
	public void setVehiculoDisponible(Vehiculo v) throws NoVehiculoException  {
		if (!vehiculosEnUso.remove(v))
			throw new NoVehiculoException("El vehiculo seleccionado no esta en uso");
		this.vehiculos.add(v);
	}
	public void setViajeFinalizado(IViaje v) {
		//if (!viajes.remove(v))
		//	throw new NoVehiculoException("El vehiculo seleccionado no esta en uso");//agrega una excepcion de viaje no encontrado
		
		this.viajesFinalizados.add(v);
	}
	
	public List<Pedido> getPedidos(){
		return this.pedidos;
	}
	public void agregaPedido(Pedido p) {
		this.pedidos.add(p);
	}
	public void agregoViaje(IViaje v) {
		this.viajes.add(v);
	}
	
	
	/**
	 * 
	 * @param chofer
	 * @param desde
	 * @param hasta
	 * 
	 * <br> precondiciones: desde tiene que ser una fecha menor o igual a hasta
	 */
	public void muestraViajes(Chofer chofer, Date desde, Date hasta) {
		List<IViaje> viajesChofer = getViajes(chofer);
		System.out.println("Viajes de "+chofer.getNombre());
		for(IViaje viaje: viajesChofer) {
			if (viaje.getFecha().after(desde) && viaje.getFecha().before(hasta)) {				
				System.out.println(viaje);
			}
		}
	}
	
	/**
	 * 
	 * @param chofer
	 * @param desde
	 * @param hasta
	 * 
	 * <br> precondiciones: desde tiene que ser una fecha menor o igual a hasta
	 */
	public void muestraViajes(Cliente cliente, Date desde, Date hasta) {
		List<IViaje> viajesChofer = getViajes(cliente);
		System.out.println("Viajes de "+cliente.getNombre());
		for(IViaje viaje: viajesChofer) {
			if (viaje.getFecha().after(desde) && viaje.getFecha().before(hasta)) {				
				System.out.println(viaje);
			}
		}
	}
}
	
	
	

	
	