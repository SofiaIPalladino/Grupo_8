package modelo;

public class ViajeFactory {
	public IViaje getViaje(Pedido pedido, Chofer chofer, Vehiculo vehiculo) {
		IViaje viaje;
		viaje=null;
		
		if(pedido.getZona().equalsIgnoreCase("Estandar")) {
			viaje=new ViajeZonaEstandar(pedido,chofer,vehiculo);
		}
		else if(pedido.getZona().equalsIgnoreCase("Calle sin afaltar")) {
			viaje=new ViajeZonaCalleSinAfaltar(pedido,chofer,vehiculo);
		}
		else if(pedido.getZona().equalsIgnoreCase("Zona Peligrosa")){
			viaje=new ViajeZonaPeligrosa(pedido,chofer,vehiculo);
		}
		
		
		if(pedido.getMascota()) {
			viaje=new DecoratorConMascota(viaje);
		}

		if(pedido.getEquipaje().equalsIgnoreCase("Baul")) {
			viaje=new DecoratorEquipajeBaul(viaje);
		}
		
		return viaje;
	}
}
