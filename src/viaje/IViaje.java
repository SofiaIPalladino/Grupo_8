package viaje;

import chofer.Chofer;
import pedido.Pedido;
import vehiculo.Vehiculo;

/**
 * Interfaz que modela una parte del comportamiento de los viajes.<br>
 */
public interface IViaje {

	double getCosto();
	Pedido getPedido();
    double getDistanciaReal();
    void setStatus(String s);
    String getStatus();
    Chofer getChofer();
    Vehiculo getVehiculo();
}
