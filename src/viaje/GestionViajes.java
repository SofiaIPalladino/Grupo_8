package viaje;

import java.util.List;

import chofer.Chofer;
import chofer.ChoferContratado;
import chofer.ChoferTemporario;
import excepciones.NoChoferException;
import excepciones.NoVehiculoException;
import excepciones.ViajeNoEncontradoException;
import pedido.Pedido;
import sistema.Empresa;
import usuario.Cliente;
import vehiculo.Vehiculo;

public class GestionViajes {

	ViajeFactory viajeFactory=new ViajeFactory();
	
	public void CreoViaje() {
		Empresa e=Empresa.getInstance();
		List<Pedido> pedidos=e.getPedidos();
		
		Pedido p= null;
		Vehiculo v=null;
		int i=0;
		while(i<pedidos.size()) {
			p=pedidos.get(i);
			v=getVehiculo(e.getVehiculos(),p.getCantPersonas(),p.usoBaul(),p.getMascota());
			if(v!=null) {
				Chofer c=null;
				try {
					c=buscarChofer(e.getChoferes());
					e.setChoferConViaje(c);
					e.setVehiculoConViaje(v);
					IViaje viaje=viajeFactory.getViaje(p, c, v);
					e.agregoViaje(viaje);	
					if (c instanceof ChoferContratado) {
						ChoferContratado auxc=(ChoferContratado) c;
						auxc.recaudaDeViaje(viaje.getCosto());
					}
					System.out.println("Viaje Creado Con exito");
				} catch (NoChoferException | NoVehiculoException e1) {////separar 
					// TODO Auto-generated catch block
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
			if(viaje.getPedido().getCliente().getUsuario().equals(c.getUsuario())){
				viaje.setStatus("Pagado");
				e.sumaRecaudado(viaje.getCosto());
				pagado=true;
			}
		}
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
			}
		}
		throw new ViajeNoEncontradoException();
	}

	
		
	
	private Vehiculo getVehiculo(Pedido pedido) throws NoVehiculoException {		   
		List<Vehiculo> listadoVehiculos = Empresa.getInstance().getVehiculos();
		int i = 0;
	    Vehiculo mejorVehiculo = null;
	    int mayorPrioridad = 0;
	    while (i < listadoVehiculos.size()) {
	    	Vehiculo vehiculo = listadoVehiculos.get(i);
	    	Integer prioridad = vehiculo.getPrioridad(pedido);
	        if (prioridad != null && prioridad.intValue() > mayorPrioridad) { // si prioridad es igual a null, el vehiculo no es apto para el pedido
	        	mayorPrioridad = prioridad.intValue();
	        	mejorVehiculo = vehiculo;
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
