package modelo;

public class ViajeZonaCalleSinAfaltar extends Viaje {

	public ViajeZonaCalleSinAfaltar(Pedido pedido, Chofer chofer, Vehiculo vehiculo) {
		super(pedido,chofer,vehiculo);
	}

	public double getCosto() {
		double incrXPersona=Viaje.getCostoBase()*this.getPedido().getCantPersonas()*0.20;
		double incrXKm=Viaje.getCostoBase()*this.getDistanciaReal()*0.15;
		return Viaje.getCostoBase()+incrXPersona+incrXKm;
	}
}