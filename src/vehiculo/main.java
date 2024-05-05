package vehiculo;

import excepciones.UsuarioExistenteException;
import modelo.Pedido;
import usuario.Cliente;
import usuario.GestionDeUsuarios;

public class main {

	public static void main(String[] args) {
		try {			
			Cliente cliente = (Cliente) GestionDeUsuarios.creaUsuario("bautistar", "123", "Bautista", "Rodriguez", false);
			Pedido pedidomascota=new Pedido("122q3412", "asdcwef", true, "UsoBaul", 3, cliente);
			Pedido pedidobaul=new Pedido("122q3412", "asdcwef", false, "UsoBaul", 4, cliente);
			Pedido pedidocombi=new Pedido("122q3412", "asdcwef", false, "UsoBaul", 6, cliente);
			Pedido pedidoqueno=new Pedido("122q3412", "asdcwef", true, "UsoBaul", 9, cliente);
			
			Automovil auto1=new Automovil("456624",4,true,true);
			Moto moto1=new Moto("32143",1,false,false);
			Combi combi1=new Combi("2325353",10,false,true);
			
			
			
			
			System.out.println(combi1.getPrioridad(pedidocombi));
		}
		catch(UsuarioExistenteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	

}
