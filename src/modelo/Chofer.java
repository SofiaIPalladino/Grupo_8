package modelo;

import java.time.LocalDate;

public abstract class Chofer {
    private String dni;
    private String nombre;
    private double sueldoBasico;
    private double plusAntiguedad;
    private double plusHijos;
    private double aportes;
    private LocalDate fechaIngreso;

    public Chofer(String dni, String nombre, double sueldoBasico, double plusAntiguedad, double plusHijos, double aportes, LocalDate fechaIngreso) {
        this.dni = dni;
        this.nombre = nombre;
        this.sueldoBasico = sueldoBasico;
        this.plusAntiguedad = plusAntiguedad;
        this.plusHijos = plusHijos;
        this.aportes = aportes;
        this.fechaIngreso = fechaIngreso;
    }

    // Getters y setters

    public abstract double calcularSueldo();
}