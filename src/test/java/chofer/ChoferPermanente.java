package chofer;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Clase que representa a un chofer permanente de la empresa.
 * Esta clase extiende la clase Chofer y agrega características específicas para los choferes permanentes.
 */
public class ChoferPermanente extends Chofer {

	private static double sueldoBasico=20000;
    private double plusXAntiguedad=0.1;
    private double plusXHijos=0.05;
    private double aportes;
    private int cantHijos;
    private LocalDate fechaIngreso;

    /**
     * Constructor para crear un ChoferPermanente.
     * @param dni El número de identificación del chofer.
     * @param nombre El nombre del chofer.
     * @param sueldoBasico El sueldo básico del chofer permanente.
     * @param plusXAntiguedad El porcentaje de aumento por antigüedad.
     * @param plusXHijos El porcentaje de aumento por cantidad de hijos.
     * @param aportes El porcentaje de descuento por aportes jubilatorios.
     * @param fechaIngreso La fecha de ingreso del chofer a la empresa.
     */
    public ChoferPermanente(String dni, String nombre, int cantHijos, LocalDate fechaIngreso) {
    	super(dni, nombre);
    	this.fechaIngreso = fechaIngreso;
    	this.cantHijos = cantHijos;
    }
    
    /**
     * Método para obtener el sueldo de un chofer permanente.
     * Este método calcula el sueldo bruto del chofer permanente, teniendo en cuenta su sueldo básico,
     * los pluses por antigüedad y cantidad de hijos, y los descuentos por aportes jubilatorios.
     * @return El sueldo neto del chofer permanente.
    */
    @Override
    public double getSueldo() {
        double sueldo = sueldoBasico;
        // Aquí se calcula el sueldo bruto (sueldo basico + pluses).
        sueldo += sueldoBasico * (plusXAntiguedad*getAntiguedad());
        sueldo += sueldoBasico * (plusXHijos*this.cantHijos);
        // Aquí se le restan los aportes al sueldo bruto.
        sueldo -= sueldo * aportes;
        return sueldo;
    }

	public double getPlusXAntiguedad() {
		return plusXAntiguedad;
	}

	public void setPlusXAntiguedad(double plusXAntiguedad) {
		this.plusXAntiguedad = plusXAntiguedad;
	}

	public double getPlusXHijos() {
		return plusXHijos;
	}

	public void setPlusXHijos(double plusXHijos) {
		this.plusXHijos = plusXHijos;
	}

	public double getAportes() {
		return aportes;
	}

	public void setAportes(double aportes) {
		this.aportes = aportes;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public double getSueldoBasico() {
		return sueldoBasico;
	}
	
    
	public int getAntiguedad() {
        long anios = ChronoUnit.YEARS.between(this.fechaIngreso, LocalDate.now());
        return (int) anios;
    }
	
}
