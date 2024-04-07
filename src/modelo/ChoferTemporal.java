package modelo;

public class ChoferTemporal extends Chofer {
    public ChoferTemporal(String dni, String nombre, double sueldoBasico, double plusAntiguedad, double plusHijos, double aportes, LocalDate fechaIngreso) {
        super(dni, nombre, sueldoBasico, plusAntiguedad, plusHijos, aportes, fechaIngreso);
    }

    @Override
    public double calcularSueldo() {
        // implementacion del calculo del sueldo para un chofer temporal
    }
}