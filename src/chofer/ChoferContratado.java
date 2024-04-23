package chofer;

public class ChoferContratado extends Chofer {
	private double recaudado;
	private float porcentaje;
	
	
	public ChoferContratado(String dni, String nombre,float por) {
		super(dni, nombre);
		this.porcentaje=por;
	}

	public float getSueldo() {
		return (float) (this.recaudado*(this.porcentaje/100));
	}

}
