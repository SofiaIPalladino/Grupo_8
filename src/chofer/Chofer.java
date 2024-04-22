package chofer;

public abstract class Chofer {
	protected String dni;
	protected String nombre;
	
	public Chofer(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}
	
	public float getSueldo(){
		return 0;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
