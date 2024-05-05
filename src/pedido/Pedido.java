package pedido;

import java.time.LocalDate;

import usuario.Cliente;

/**
 * Clase que modela las caracteristicas de un pedido.<br>
 */
public class Pedido {
	private LocalDate  fecha;
	private String zona;
	private boolean mascota;
	private String equipaje;
	private int cantPersonas;
	private Cliente cliente;
	private double distancia;
	
	/**
	 * Construye un objeto de tipo Pedido.<br>
	 * @param fecha: fecha de realizacion del pedido.<br>
	 * @param zona: zona en donde se efectuara el viaje.<br>
	 * @param mascota: valor booleano correspondiente al transporte de mascota.<br>
	 * @param equipaje: tipo de equipaje. <br>
	 * @param cantPersonas: cantidad de personas a transportar.<br>
	 * @param cliente: cliente que realiza el pedido.<br>
	 */
	public Pedido(String zona, boolean mascota, String equipaje, int cantPersonas, Cliente cliente,double distancia) {
		this.fecha = LocalDate.now();
		this.zona = zona;
		this.mascota = mascota;
		this.equipaje = equipaje;
		this.cantPersonas = cantPersonas;
		this.cliente = cliente;
		this.distancia=distancia;
	}

	public double getDistancia() {
		return distancia;
	}
	
	public LocalDate  getFecha() {
		return fecha;
	}
	public String getZona() {
		return zona;
	}
	public boolean getMascota() {
		return mascota;
	}
	public String getEquipaje() {
		return equipaje;
	}
	
	public boolean usoBaul() {
		if (this.equipaje==("Baul"))
			return true;
		else 
			return false;
	}
	
	public int getCantPersonas() {
		return cantPersonas;
	}
	
	@Override
	public String toString() {
		return "Pedido [fecha=" + fecha + ", zona=" + zona + ", mascota=" + mascota + ", equipaje=" + equipaje
				+ ", cantPersonas=" + cantPersonas + "]";
	}
	
	public Cliente getCliente() {return this.cliente;}
	
}