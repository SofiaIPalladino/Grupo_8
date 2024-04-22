package chofer;

public class ChoferTemporario extends Chofer {
	private float sueldobasico;
	private float aportes;
	private float plusxcantviajes;
	private int cantviajes;
	
	public ChoferTemporario(String dni, String nombre, float sueldobasico, float aportes, float plusxcantviajes,
			int cantviajes) {
		super(dni, nombre);
		this.sueldobasico = sueldobasico;
		this.aportes = aportes;
		this.plusxcantviajes = plusxcantviajes;
		this.cantviajes = cantviajes;
	}

	public float getSueldo() {
		return this.sueldobasico;
	}

	public float getSueldobasico() {
		return sueldobasico;
	}

	public void setSueldobasico(float sueldobasico) {
		this.sueldobasico = sueldobasico;
	}

	public float getPlusxcantviajes() {
		return plusxcantviajes;
	}

	public void setPlusxcantviajes(float plusxcantviajes) {
		this.plusxcantviajes = plusxcantviajes;
	}

	public float getAportes() {
		return aportes;
	}

	public int getCantviajes() {
		return cantviajes;
	}
	
	
}
