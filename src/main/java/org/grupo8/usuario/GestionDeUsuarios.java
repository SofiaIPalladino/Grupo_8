package org.grupo8.usuario;

import org.grupo8.excepciones.UsuarioExistenteException;
import org.grupo8.excepciones.UsuarioInexistenteException;
import org.grupo8.sistema.Empresa;
import org.grupo8.viaje.IViaje;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Esta clase se encarga de gestionar a los usuarios, permitiendo crearlos, modificarlos,
 * consultar la existencia de los mismos y mostrar el listado de viajes realizados por un cliente ingresado
 * 
 * 
 */



public class GestionDeUsuarios{
	
	public Usuario creaUsuario(Usuario usuario) throws UsuarioExistenteException {
		  Iterator<Usuario> iterator =  Empresa.getInstance().getUsuarios().iterator();
	        while (iterator.hasNext()) {
	            Usuario usuarios1 = iterator.next();
	            if (usuarios1.getUsuario().equals(usuario.getUsuario())) {
	            	throw new UsuarioExistenteException("Usuario ya existente: "+usuario.getUsuario());
	            }
	        }
	       UsuarioFactory factoryUsuario = new UsuarioFactory();
	       return factoryUsuario.crea(usuario);
	}
	
	public void modificaUsuario(String nombreUsuario, String contraseniaNueva, String nombre, String apellido) throws UsuarioInexistenteException {
		List<Usuario> listaUsuarios = Empresa.getInstance().getUsuarios();
		Usuario usuario = null;
		int i=0;
		while (i < listaUsuarios.size() && usuario == null) {
			Usuario usuarioAux = listaUsuarios.get(i);
			if (usuarioAux.getUsuario().equalsIgnoreCase(nombreUsuario)) {
				usuario = usuarioAux;
			}
		}
		if (usuario == null) {
			throw new UsuarioInexistenteException("El usuario: " + nombreUsuario + " no existe");
		}
		if(contraseniaNueva != null) {
			usuario.setContrasenia(contraseniaNueva);
		}
		if(nombre != null) {
			usuario.setNombre(nombre);
		}
		if(apellido != null) {
			usuario.setApellido(apellido);
		}
	}
	
	public Usuario consultaUsuario(String nombreUsuario) {
		List<Usuario> listaUsuarios = Empresa.getInstance().getUsuarios();
		int i=0;
		while (i < listaUsuarios.size()) {
			Usuario usuario = listaUsuarios.get(i);
			if (usuario.getUsuario().equalsIgnoreCase(nombreUsuario)) {
				return usuario;
			}
		}
		
		return null;
	}
	
	public List<IViaje> getViajes(Cliente cliente){
		List<IViaje> listadoViajes = Empresa.getInstance().getViajes();
		List<IViaje> viajesUsuario = new ArrayList<IViaje>();
		for(IViaje viaje: listadoViajes) {
			if (viaje.getCliente() == cliente) {				
				viajesUsuario.add(viaje);
			}
		}
		return viajesUsuario;
	}
}
