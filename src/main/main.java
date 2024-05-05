package main;

import java.util.Date;

import excepciones.UsuarioExistenteException;
import pedido.Pedido;
import usuario.Cliente;
import usuario.GestionDeUsuarios;
import usuario.Usuario;
import usuario.UsuarioFactory;
import vehiculo.Automovil;
import vehiculo.Combi;
import vehiculo.Moto;

public class main {

	public static void main(String[] args) {
		GestionDeUsuarios gestion_usuarios =new GestionDeUsuarios();
		Usuario x=new Usuario("sofi", "1234","su casa", "2413256123", false);
		
		
	
		

		Cliente cliente = null;
		try {
			cliente = (Cliente) gestion_usuarios.creaUsuario( x);
		} catch (UsuarioExistenteException e) {
			// TODO Auto-generated catch block
			System.out.println("Usuario existente");
		}
		
		
		
		Pedido pedidomascota=new Pedido("asdcwef",true,"UsoBaul",3,cliente);
		Pedido pedidobaul=new Pedido("asdcwef",false,"UsoBaul",4,cliente);
		Pedido pedidocombi=new Pedido("asdcwef",false,"UsoBaul",6,cliente);
		Pedido pedidoqueno=new Pedido("asdcwef",true,"UsoBaul",9,cliente);
		
		Automovil auto1=new Automovil("456624",4,true,true);
		Moto moto1=new Moto("32143",1,false,false);
		Combi combi1=new Combi("2325353",10,false,true);
		
		
		
		
		System.out.println(combi1.getPrioridad(pedidocombi));
	}
	
	

}
