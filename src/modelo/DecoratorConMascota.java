package modelo;

public class DecoratorConMascota extends DecoratorViajes {

	public DecoratorConMascota(IViaje encapsulado) {
		super(encapsulado);
	}

	@Override
	public double getCosto() {
		
		double costoEncapsulado=this.encapsulado.getCosto();
		double incrXPersona=Viaje.costoBase*0.10*this.encapsulado.getPedido().getCantPersonas();
		double incrXKm=Viaje.costoBase*0.20*this.encapsulado.getDistanciaReal();
		
		return costoEncapsulado+incrXPersona+incrXKm;
	}

	@Override
	public Pedido getPedido() {
		return this.encapsulado.getPedido();
	}
}
