package modelo;

import vehiculo.Vehiculo;

public class ViajeZonaPeligrosa extends Viaje{

	public ViajeZonaPeligrosa(Pedido pedido, Chofer chofer, Vehiculo vehiculo) {
		super(pedido,chofer,vehiculo);
	}

	public double getCosto() {
		double incrXPersona=Viaje.costoBase*this.getPedido().getCantPersonas()*0.10;
		double incrXKm=Viaje.costoBase*this.getDistanciaReal()*0.20;
		return Viaje.costoBase+incrXPersona+incrXKm;
	}
}
