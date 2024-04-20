package modelo;

public class DecoratorEquipajeBaul extends DecoratorViajes {

	public DecoratorEquipajeBaul(IViaje encapsulado) {
		super(encapsulado);
	}

	@Override
	public double getCosto() {
		double costoEncapsulado=this.encapsulado.getCosto();
		double incrXPersona=costoEncapsulado*0.10*this.encapsulado.getPedido().getCantPersonas();
		double incrXKm=costoEncapsulado*0.05*this.encapsulado.getDistanciaReal();
		
		return costoEncapsulado+incrXPersona+incrXKm;
	}
	@Override
	public Pedido getPedido() {
		return this.encapsulado.getPedido();
	}

}
