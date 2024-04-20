package modelo;

public abstract class Empleado extends Chofer {
	
	protected double sueldoBase;
	
	protected Empleado(String nombre, String dni) {
		super(nombre, dni);
	}
	protected abstract double getSueldoBruto();
	protected abstract double getSueldoNeto();
}
