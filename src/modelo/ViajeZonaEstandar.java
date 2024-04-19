package modelo;

public class ViajeZonaEstandar extends Viaje{

	public ViajeZonaEstandar(Pedido pedido, Chofer chofer, Vehiculo vehiculo) {
		super(pedido,chofer,vehiculo);
	}

	public double getCosto() {
		double incrXPersona=Viaje.costoBase*this.getPedido().getCantPersonas()*0.10;
		double incrXKm=Viaje.costoBase*this.getDistanciaReal()*0.10;
		return Viaje.costoBase+incrXPersona+incrXKm;
	}
}
