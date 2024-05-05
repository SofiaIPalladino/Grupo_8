package usuario;

import java.util.Iterator;

import excepciones.UsuarioExistenteException;
import excepciones.UsuarioInvalidoException;

public class GestionDeUsuarios{
	
	public static Usuario creaUsuario(String usuario, String contrasenia, String nombre, String apellido,boolean admin) throws UsuarioExistenteException, UsuarioInvalidoException {
		//Estas verificaciones en la segunda parte se van a realizar en la ventana que reciba el input
		if(usuario == null || usuario == "") {
			throw new UsuarioInvalidoException("Nombre de usuario invalido");
		}
		if(contrasenia == null || contrasenia == "") {
			throw new UsuarioInvalidoException("Contrasenia invalida");
		}
		if(nombre == null || nombre == "") {
			throw new UsuarioInvalidoException("Nombre invalido");
		}
		if(apellido == null || apellido == "") {
			throw new UsuarioInvalidoException("Apellido invalido");
		}
		
		Iterator<Usuario> iterator = Empresa.getInstance().getUsuarios().iterator();
		while (iterator.hasNext()) {
			Usuario usuarios1 = iterator.next();
			if (usuarios1.getUsuario().equals(usuario)) {
				throw new UsuarioExistenteException("Usuario ya existente: "+usuario);   
			}   
		}
		return UsuarioFactory.crea(usuario, contrasenia, nombre, apellido, admin);
	}
}
