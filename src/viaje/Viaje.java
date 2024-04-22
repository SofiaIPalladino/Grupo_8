package viaje;

import chofer.Chofer;
import modelo.Pedido;
import vehiculo.Vehiculo;

public abstract class Viaje implements IViaje {
	
	protected Pedido pedido;
	protected Chofer chofer;
	protected double distanciaReal,costo;
	protected static double costoBase=1000;
	protected Vehiculo vehiculo;
	
	
	public Viaje(Pedido pedido, Chofer chofer, Vehiculo vehiculo) {
		this.pedido=pedido;
		this.chofer=chofer;
		this.vehiculo=vehiculo;
	}
	
    //pre y exc
	protected void setDistanciaReal(double dist) {
		this.distanciaReal=dist;	
	}
	protected static double getCostoBase() {
		return Viaje.costoBase;
	}
	//pre y exc
	protected static void setCostoBase(double costoBase) {
		Viaje.costoBase=costoBase;
	}
	/**
	 * 
	 */
	public double getDistanciaReal() {
		return this.distanciaReal;
	}
	public Pedido getPedido() {
		return pedido;
	}
	

}
