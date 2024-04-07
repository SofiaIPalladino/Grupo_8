package modelo;

public class ChoferContratado extends Chofer {
    public ChoferContratado(String dni, String nombre, double sueldoBasico, double plusAntiguedad, double plusHijos, double aportes, LocalDate fechaIngreso) {
        super(dni, nombre, sueldoBasico, plusAntiguedad, plusHijos, aportes, fechaIngreso);
    }

    @Override
    public double calcularSueldo() {
        // implementación del calculo del sueldo para un chofer contratado
    }
}


