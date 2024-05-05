package main;

import java.util.Date;

import excepciones.UsuarioExistenteException;
import excepciones.UsuarioInvalidoException;
import pedido.Pedido;
import usuario.Cliente;
import usuario.GestionDeUsuarios;
import vehiculo.Automovil;
import vehiculo.Combi;
import vehiculo.Moto;

public class prueba {

	public static void main(String[] args) {
		Cliente cliente = null;
		try {			
			cliente = (Cliente) GestionDeUsuarios.creaUsuario("bautistar", "123", "Bautista", "Rodriguez", false);
		}
		catch(UsuarioExistenteException e) {
			System.out.println(e.getMessage());
		}
		catch(UsuarioInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		Pedido pedidomascota=new Pedido(new Date(), "asdcwef", true, "UsoBaul", 3, cliente, 12);
		Pedido pedidobaul=new Pedido(new Date(), "asdcwef", false, "UsoBaul", 4, cliente, 8);
		Pedido pedidocombi=new Pedido(new Date(), "asdcwef", false, "UsoBaul", 6, cliente, 7.4);
		Pedido pedidoqueno=new Pedido(new Date(), "asdcwef", true, "UsoBaul", 9, cliente, 1.9);
		
		Automovil auto1=new Automovil("456624",4,true,true);
		Moto moto1=new Moto("32143",1,false,false);
		Combi combi1=new Combi("2325353",10,false,true);
		
		
		
		
		System.out.println(combi1.getPrioridad(pedidocombi));
	}
}
