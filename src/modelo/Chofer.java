package modelo;

public abstract class Chofer {
	protected String dni;
	protected String nombre;
	
	protected Chofer(String nombre, String dni) {
		this.nombre=nombre;
		this.dni=dni;
	}
	
	protected abstract double calcularSueldo();
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	
}
