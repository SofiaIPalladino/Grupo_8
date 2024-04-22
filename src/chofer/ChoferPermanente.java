package chofer;

public class ChoferPermanente extends Chofer {
	private float sueldobasico;
	private int antiguedad;
	private int canthijos;
	private float aportes;
	private final String fechaing;
	
	public ChoferPermanente(String dni, String nombre, float sueldobasico, int antiguedad, int canthijos, float aportes,
			String fechaing) {
		super(dni, nombre);
		this.sueldobasico = sueldobasico;
		this.antiguedad = antiguedad;
		this.canthijos = canthijos;
		this.aportes = aportes;
		this.fechaing = fechaing;
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

	public int getAntiguedad() {
		return antiguedad;
	}

	public int getCanthijos() {
		return canthijos;
	}

	public float getAportes() {
		return aportes;
	}

	public String getFechaing() {
		return fechaing;
	}
	
	
	
	
	
}
