package usuario;

public class UsuarioFactory {
	public static Usuario crea(String usuario, String contrasenia, String nombre, String apellido,boolean admin) {
		if (!admin)
			return new Cliente(usuario, contrasenia, nombre, apellido);
		return null; //por el momento no se necesita una clase Admin, por lo cual devolvemos null
	}
}
