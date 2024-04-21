package vehiculo;

import modelo.Pedido;

public abstract class Vehiculo {
	protected String numpatente;
	protected final int cantmaxpas;
	protected final boolean petfriendly;
	protected final boolean baul;
	
	public Vehiculo(String numpatente,int cantmaxpas, boolean petfriendly, boolean baul) {
		this.numpatente=numpatente;
		this.cantmaxpas = cantmaxpas;
		this.petfriendly = petfriendly;
		this.baul = baul;
	}
	
	public int getPrioridad(Pedido pedido) {
		
		if(!cantPas(pedido.getCantPersonas())){
			return 0;
		}
		if(!usoBaul(pedido.usoBaul())) {
			return 0;
		}
		if(!petFriendly(pedido.getMascota())){
			return 0;
		}
		return califica(pedido);		
		
	}
	
	public boolean cantPas(int pas){
		return false;
	}
	
	public boolean usoBaul(boolean baul) {
		return false;
		
	}
	
	public boolean petFriendly(boolean pet) {
		return false;
		
	}
	
	public int califica(Pedido pedido) {
		return 0;
		
	}
	
	
	


}
