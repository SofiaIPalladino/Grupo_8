package viaje;

import chofer.Chofer;
import pedido.Pedido;
import usuario.Cliente;
import vehiculo.Vehiculo;

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
