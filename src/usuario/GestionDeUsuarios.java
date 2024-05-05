package usuario;

import java.util.Iterator;

import excepciones.UsuarioExistenteException;
import sistema.Empresa;

public class GestionDeUsuarios{
	
	public Usuario creaUsuario(Usuario usuario) throws UsuarioExistenteException {
		  Iterator<Usuario> iterator = Empresa.getInstance().getUsuarios().iterator();
	        while (iterator.hasNext()) {
	            Usuario usuarios1 = iterator.next();
	            if (usuarios1.getUsuario().equals(usuario.getUsuario())) {
	            	throw new UsuarioExistenteException("Usuario ya existente: "+usuario.getUsuario());
	            }
	        }
	       UsuarioFactory factoryUsuario = new UsuarioFactory();
	       return factoryUsuario.crea(usuario);
	}
}
