package org.grupo8.viaje;


import org.grupo8.chofer.Chofer;
import org.grupo8.chofer.ChoferContratado;
import org.grupo8.excepciones.NoChoferException;
import org.grupo8.excepciones.NoVehiculoException;
import org.grupo8.excepciones.ViajeNoEncontradoException;
import org.grupo8.pedido.Pedido;
import org.grupo8.sistema.Empresa;
import org.grupo8.usuario.Cliente;
import org.grupo8.vehiculo.Vehiculo;

import java.util.List;

public class GestionViajes {

	ViajeFactory viajeFactory=new ViajeFactory();
	
	public void CreoViaje() throws NoVehiculoException {
		Empresa e=Empresa.getInstance();
		List<Pedido> pedidos=e.getPedidos();
		
		Pedido p= null;
		Vehiculo v=null;
		int i=0;
		while(i<pedidos.size()) {
			p=pedidos.get(i);
			v=getVehiculo(p);
			i++;
			if(v!=null) {
				Chofer c=null;
				try {
					c=buscarChofer(e.getChoferes());
					e.setChoferConViaje(c);
					e.setVehiculoConViaje(v);
					IViaje viaje=viajeFactory.getViaje(p, c, v);
					c.agregaViaje();
					c.agregaKm(p.getDistancia());
					e.agregoViaje(viaje);
					e.aceptaPedido(p);
					if (c instanceof ChoferContratado) {
						ChoferContratado auxc=(ChoferContratado) c;
						auxc.recaudaDeViaje(viaje.getCosto());
					}
					
					System.out.println("Viaje Creado Con exito");
				} catch (NoChoferException e1) {////separar
					e1.printStackTrace();
				}			
			}
				
		}	
				
	}
	
	public void PagoViaje(Cliente c) throws ViajeNoEncontradoException {
		Empresa e=Empresa.getInstance();
		List<IViaje> viajes=e.getViajes();
        int i = 0;
        boolean pagado =false;
        IViaje viaje=null;
		while (i < viajes.size()&& !pagado) {
			viaje= viajes.get(i);
			if(viaje.getCliente().equals(c)){
				viaje.setStatus("Pagado");
				e.sumaRecaudado(viaje.getCosto());
				pagado=true;
				System.out.println("Viaje pagado con exito");
			}
			i++;
		}
		if (!pagado)
			throw new ViajeNoEncontradoException();
	}

	
	public void finalizarViaje(Chofer c) throws ViajeNoEncontradoException {
		Empresa e=Empresa.getInstance();
		List<IViaje> viajes=e.getViajes();
        int i = 0;
        boolean finalizado =false;
        IViaje viaje=null;
		while (i < viajes.size()&& !finalizado) {
			viaje= viajes.get(i);
			if(viaje.getChofer().getDni()==c.getDni()){
				viaje.setStatus("Finalizado");
				
				try {
					e.setChoferDisponible(c);
					e.setVehiculoDisponible(viaje.getVehiculo());
				} catch (NoChoferException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoVehiculoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finalizado=true;
				System.out.println("Viaje finalizado con exito");
			}
		}
		if (!finalizado)
			throw new ViajeNoEncontradoException();
	}	
	
	private static Vehiculo getVehiculo(Pedido pedido) throws NoVehiculoException {		   
		List<Vehiculo> listadoVehiculos = Empresa.getInstance().getVehiculos();
		int i = 0;
	    Vehiculo mejorVehiculo = null;
	    int mayorPrioridad = 0;
	    while (i < listadoVehiculos.size()) {
	    	Vehiculo v = listadoVehiculos.get(i);
	    	Integer prioridad = v.getPrioridad(pedido);
	        if (prioridad != null && prioridad.intValue() > mayorPrioridad) {// si prioridad es igual a null, el vehiculo no es apto para el pedido
	        	if(v.verificaPasajeros(pedido.getCantPersonas()) && v.verificaBaul(pedido.usoBaul())&& v.verificaMascota(pedido.getMascota())) {
	        		mayorPrioridad = prioridad.intValue();
		        	mejorVehiculo = v;
	        	}
	        }
	        i++;
	    }
	    if (mejorVehiculo != null) {
	    	return mejorVehiculo;
	    }
	    throw new NoVehiculoException("No se encontro un vehiculo acorde al pedido");
	}
	
	
	private static Chofer buscarChofer(List<Chofer> c) throws NoChoferException {
        int i = 0;
        Chofer p=null;
        while (i < c.size()) {
        	p = c.get(i);
        	return p;
            }
            i++;
        
            throw new NoChoferException("NO existe un chofer disponible");
    }
	
}
