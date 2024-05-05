package viaje;

import java.util.Date;

import chofer.Chofer;
import pedido.Pedido;
import usuario.Cliente;
import vehiculo.Vehiculo;

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
    Date getFecha();
}
