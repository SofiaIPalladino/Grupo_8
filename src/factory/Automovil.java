package factory;

import modelo.Pedido;

public class Automovil extends Vehiculo {

	public Automovil(String numpatente, int cantmaxpas, boolean petfriendly, boolean baul) {
		super(numpatente, cantmaxpas, petfriendly, baul);
	}
	
	public boolean cantPas(int pas){
		if (pas>this.cantmaxpas)
			return false;
		else
			return true;
	}
	
	public boolean usoBaul(boolean baul) {
		if (baul==this.baul || !baul)
			return true;
		else
			return false;
		
	}
	
	public boolean petFriendly(boolean pet) {
		if (pet==this.petfriendly || !pet)
			return true;
		else
			return false;
		
	}
	
	public int califica(Pedido pedido) {
		if(pedido.usoBaul())
			return 40*pedido.getCantPersonas();		
		return 30*pedido.getCantPersonas();
	}
	
	

}
