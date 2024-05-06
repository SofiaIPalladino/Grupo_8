package org.grupo8.viaje;


import org.grupo8.chofer.Chofer;
import org.grupo8.pedido.Pedido;
import org.grupo8.usuario.Cliente;
import org.grupo8.vehiculo.Vehiculo;

import java.time.LocalDate;

/**
 * Interfaz que modela una parte del comportamiento de los viajes.<br>
 */
public interface IViaje extends Comparable<IViaje>{

	double getCosto();
	Pedido getPedido();
    double getDistanciaReal();
    void setStatus(String s);
    String getStatus();
    Chofer getChofer();
    Vehiculo getVehiculo();
    Cliente getCliente();
    LocalDate getFecha();
}
