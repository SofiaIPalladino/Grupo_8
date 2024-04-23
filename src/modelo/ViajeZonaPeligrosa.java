package modelo;

public class ViajeZonaPeligrosa extends Viaje{

	public ViajeZonaPeligrosa(Pedido pedido, Chofer chofer, Vehiculo vehiculo) {
		super(pedido,chofer,vehiculo);
	}

	public double getCosto() {
		double incrXPersona=Viaje.getCostoBase()*this.getPedido().getCantPersonas()*0.10;
		double incrXKm=Viaje.getCostoBase()*this.getDistanciaReal()*0.20;
		return Viaje.getCostoBase()+incrXPersona+incrXKm;
	}
}
