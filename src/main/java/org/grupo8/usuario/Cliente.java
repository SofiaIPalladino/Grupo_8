package org.grupo8.usuario;

public class Cliente extends Usuario{
    
    public Cliente(Usuario usuario) {
		super(usuario.getUsuario(), usuario.getContrasenia(), usuario.getNombre(), usuario.getApellido(), false);
	}
    
	
}
