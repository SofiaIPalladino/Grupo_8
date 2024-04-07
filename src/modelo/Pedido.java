package modelo;

import java.time.LocalDateTime;

public class Pedido {
    private Cliente cliente;
    private LocalDateTime fecha;
    private TipoServicio tipoServicio;
    private Zona zona;
    private boolean mascota;
    private TipoEquipaje tipoEquipaje;
    private int cantidadPasajeros;

    public Pedido(Cliente cliente, LocalDateTime fecha, TipoServicio tipoServicio, Zona zona, boolean mascota, TipoEquipaje tipoEquipaje, int cantidadPasajeros) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.tipoServicio = tipoServicio;
        this.zona = zona;
        this.mascota = mascota;
        this.tipoEquipaje = tipoEquipaje;
        this.cantidadPasajeros = cantidadPasajeros;
    }

}