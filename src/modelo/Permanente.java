package modelo;

public class Permanente extends Empleado {

	
	
	
	protected Permanente(String nombre, String dni) {
		super(nombre, dni);
	}
	@Override
	protected double getSueldoBruto() {
		return 0;
	}
	@Override
	protected double getSueldoNeto() {
		return 0;
	}
	@Override
	protected double calcularSueldo() {
		return 0;
	}

}
