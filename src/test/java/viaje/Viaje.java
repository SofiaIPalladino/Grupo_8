package viaje;

import chofer.Chofer;
import pedido.Pedido;
import usuario.Cliente;
import vehiculo.Vehiculo;

import java.time.LocalDate;

/**
 * Clase abstracta que modela las caracteristicas y el comportamoiento de los viajes.<br>
 */
public abstract class Viaje implements IViaje {
	
	protected String status;
	protected Pedido pedido;
	protected Chofer chofer;
	protected Cliente cliente;
	protected double distanciaReal,costo;
	protected static double costoBase=1000;
	protected Vehiculo vehiculo;
	protected LocalDate fecha;

	
	public Viaje(Pedido pedido, Chofer chofer, Vehiculo vehiculo) {
		this.pedido=pedido;
		this.chofer=chofer;
		this.vehiculo=vehiculo;
		this.status="solicitado";
		this.fecha = LocalDate.now();
		this.distanciaReal=pedido.getDistancia();
		this.cliente=pedido.getCliente();
		
	}
	
    /**
     * Este metodo setea el atributo distanciaReal con el valor recibido como parametro.<br>
     * <br> Precondicion: parametro mayor a 0.<br>
     * @param dist: nuevo valor a asignar.<br>
     */
	protected void setDistanciaReal(double dist) {
		this.distanciaReal=dist;	
	}
	
	protected static double getCostoBase() {
		return Viaje.costoBase;
	}
	
	/**
	 * Este metodo setea el atributo estatico costoBase con el valor recibido como parametro.<br>
	 * <br> Precondicion: parametro mayor a 0.<br>
	 * @param costoBase: nuevo valor a asignar.<br>
	 */
	protected static void setCostoBase(double costoBase) {
		Viaje.costoBase=costoBase;
	}

	public double getDistanciaReal() {
		return this.distanciaReal;
	}
	public Pedido getPedido() {
		return pedido;
	}
	
	
	
	
	
	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public Chofer getChofer() {
		return this.chofer;
	}

	public void setStatus(String s) {
		this.status=s;
		
	}

	public String getStatus() {
		return this.status;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}

	/**
	 * Este metodo abstracto calculara el costo del viaje dependiento del tipo de viaje.<br>
	 */
	public abstract double getCosto();

	@Override
	public String toString() {
		return "Viaje [status=" + status + ", pedido=" + pedido + ", chofer=" + chofer + ", cliente=" + cliente
				+ ", distanciaReal=" + distanciaReal + ", costo=" + costo + ", vehiculo=" + vehiculo + "]";
	}

	@Override
	public int compareTo(IViaje viaje) {
		int rta = 0;
		if (getCosto() < viaje.getCosto())
			rta = -1;
		else if (getCosto() > viaje.getCosto())
			rta = 1;
		return rta;
	}

}
