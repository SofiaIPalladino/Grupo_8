package modelo;

/**
 * Interfaz que modela una parte del comportamiento de los viajes.<br>
 */
public interface IViaje {

	double getCosto();
	Pedido getPedido();
    double getDistanciaReal();
}
