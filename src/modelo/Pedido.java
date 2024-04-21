package modelo;

public class Pedido {
	private String fecha;
	private String zona;
	private boolean mascota;
	private String equipaje;
	private int cantPersonas;
	private Cliente cliente;
	
	public Pedido(String fecha, String zona, boolean mascota, String equipaje, int cantPersonas, Cliente cliente) {
		this.fecha = fecha;
		this.zona = zona;
		this.mascota = mascota;
		this.equipaje = equipaje;
		this.cantPersonas = cantPersonas;
		this.cliente = cliente;
	}

	public String getFecha() {
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
		if (this.equipaje==("UsoBaul"))
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
}
