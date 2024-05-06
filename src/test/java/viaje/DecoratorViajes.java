 package viaje;

 import chofer.Chofer;
 import pedido.Pedido;
 import usuario.Cliente;
 import vehiculo.Vehiculo;

 import java.time.LocalDate;

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

	public Chofer getChofer() {
		return  this.encapsulado.getChofer();
	}
	
	public Vehiculo getVehiculo() {
		return this.encapsulado.getVehiculo();
	}
	
	public Cliente getCliente() {
		return this.encapsulado.getCliente();
	}
	
	public LocalDate getFecha() {
		return this.encapsulado.getFecha();
	}

	@Override
	public String toString() {
		return encapsulado.toString();
	}
	
	@Override
	public int compareTo(IViaje viaje) {
		return this.encapsulado.compareTo(viaje);
	}
}
