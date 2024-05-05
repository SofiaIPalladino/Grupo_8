 package viaje;

import chofer.Chofer;
import pedido.Pedido;
import vehiculo.Vehiculo;

 /**
  * Clase abstracta que modela modela las caracteristicas y comportamiento comun de los encapsulados.<br>
  */
public abstract class DecoratorViajes implements IViaje {

	protected IViaje encapsulado;
	
	public DecoratorViajes(IViaje encapsulado) {
		this.encapsulado=encapsulado;
	}
	
	public double getDistanciaReal() {
		return this.encapsulado.getDistanciaReal();
	}
	public Pedido getPedido() {
		return this.getPedido();
	}
	public void setStatus(String status) {
		this.encapsulado.setStatus(status);
	}

	public String getStatus() {
		return this.encapsulado.getStatus();
	}

	@Override
	public Chofer getChofer() {
		// TODO Auto-generated method stub
		return  this.encapsulado.getChofer();
	}
	
	@Override
	public Vehiculo getVehiculo() {
		// TODO Auto-generated method stub
		return this.encapsulado.getVehiculo();
	}
}
