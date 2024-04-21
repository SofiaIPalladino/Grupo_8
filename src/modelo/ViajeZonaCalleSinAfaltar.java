package modelo;

import vehiculo.Vehiculo;

public class ViajeZonaCalleSinAfaltar extends Viaje {

	public ViajeZonaCalleSinAfaltar(Pedido pedido, Chofer chofer, Vehiculo vehiculo) {
		super(pedido,chofer,vehiculo);
	}

	public double getCosto() {
		double incrXPersona=Viaje.costoBase*this.getPedido().getCantPersonas()*0.20;
		double incrXKm=Viaje.costoBase*this.getDistanciaReal()*0.15;
		return Viaje.costoBase+incrXPersona+incrXKm;
	}
}