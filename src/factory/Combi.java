package factory;

import modelo.Pedido;

public class Combi extends Vehiculo{

	public Combi(String numpatente, int cantmaxpas, boolean petfriendly, boolean baul) {
		super(numpatente, cantmaxpas, petfriendly, baul);
	}
	
	public boolean cantPas(int pas){
		if (pas<=this.cantmaxpas)
			return true;
		else 
			return false;
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
			return 10*pedido.getCantPersonas() +100;	
		return 10*pedido.getCantPersonas();
	}
	
	
	
	

}
