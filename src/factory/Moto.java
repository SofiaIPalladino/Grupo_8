package factory;

import modelo.Pedido;

public class Moto extends Vehiculo {

	public Moto(String numpatente, int cantmaxpas, boolean petfriendly, boolean baul) {
		super(numpatente, cantmaxpas, petfriendly, baul);
	}
	
	public boolean cantPas(int pas){
		if (pas>this.cantmaxpas)
			return false;
		else 
			return true;
	}
	
	public boolean usoBaul(boolean baul) {
		if (!baul)
			return true;
		return false;
		
	}
	
	public boolean petFriendly(boolean pet) {
		if (!pet)
			return true;
		return false;
		
	}
	
	public int califica(Pedido pedido) {
		return 1000;
	}
	

}
