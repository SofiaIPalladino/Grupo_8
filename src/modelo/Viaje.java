package modelo;

import java.time.LocalDateTime;

public class Viaje {
    private Pedido pedido;
    private Chofer chofer;
    private Vehiculo vehiculo;
    private LocalDateTime fecha;
    private double costo;
    private double distanciaRecorrida;
    private EstadoViaje estado;

    public Viaje(Pedido pedido, Chofer chofer, Vehiculo vehiculo, double costo, double distanciaRecorrida, EstadoViaje estado) {
        this.pedido = pedido;
        this.chofer = chofer;
        this.vehiculo = vehiculo;
        this.costo = costo;
        this.distanciaRecorrida = distanciaRecorrida;
        this.estado = estado;
        this.fecha = LocalDateTime.now();
    }

}
