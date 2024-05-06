package main;

import chofer.*;
import excepciones.NoVehiculoException;
import excepciones.UsuarioExistenteException;
import excepciones.ViajeNoEncontradoException;
import pedido.GestionPedidos;
import pedido.Pedido;
import puntajes.GestionPuntajes;
import sistema.Empresa;
import usuario.Cliente;
import usuario.GestionDeUsuarios;
import usuario.Usuario;
import vehiculo.Automovil;
import vehiculo.Combi;
import vehiculo.Moto;
import viaje.GestionViajes;

import java.time.LocalDate;

public class main {

	public static void main(String[] args) {
		
		Empresa e=Empresa.getInstance();
		GestionDeUsuarios gestion_usuarios =new GestionDeUsuarios();
		GestionPedidos gestionPedidos=new GestionPedidos();
		GestionViajes gestionViajes=new GestionViajes();
		GestionPagoChoferes gestionPagoChoferes=new GestionPagoChoferes();
		GestionPuntajes gestionPuntajes=new GestionPuntajes();
		Usuario x=new Usuario("sofi", "1234","su casa", "2413256123", false);
		Usuario admi=new Usuario("sofi", "1234","su casa", "2413256123", true);
		Cliente cliente = null;
		try {
			cliente = (Cliente) gestion_usuarios.creaUsuario( x);
		} catch (UsuarioExistenteException ex) {
			// TODO Auto-generated catch block
			System.out.println("Usuario existente");
		}
		
		Pedido pedidomascota=new Pedido("Estandar",true,"UsoBaul",3,cliente,10);
		Pedido pedidobaul=new Pedido("Estandar",false,"UsoBaul",4,cliente,144);
		Pedido pedidocombi=new Pedido("Estandar",false,"UsoBaul",9,cliente,13);
		Pedido pedidoqueno=new Pedido("Estandar",true,"UsoBaul",9,cliente,13);	
		
		Automovil auto1=new Automovil("456624",4,true,true);
		Moto moto1=new Moto("32143",1,false,false);
		Combi combi1=new Combi("2325353",10,false,true);
		
		Chofer chofer1=new ChoferTemporario("451542","ChoferTemporario");
		Chofer chofer2=new ChoferContratado("451352","ChoferContratado");
		Chofer chofer3=new ChoferPermanente("453542","ChoferPermanente",4,LocalDate.of(2020,5,5));
		
		e.agregaVehiculo(combi1);
		e.agregaVehiculo(moto1);
		e.agregaVehiculo(auto1);
		e.agregaChofer(chofer1);
		e.agregaChofer(chofer2);
		e.agregaChofer(chofer3);
		
		gestionPedidos.evaluaPedido(pedidocombi);
		
		try {
			gestionViajes.CreoViaje();
		} catch (NoVehiculoException e1) {
			e1.printStackTrace();
		}
		
		try {
			gestionViajes.PagoViaje(cliente);
		} catch (ViajeNoEncontradoException e1) {
			e1.printStackTrace();
		}
		
		try {
			gestionViajes.finalizarViaje(chofer1);
		} catch (ViajeNoEncontradoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		gestionPagoChoferes.calculoPagoChoferes(admi);
		
		gestionPuntajes.actualizarPuntajes(admi);
		
		gestionPuntajes.MuestraPuntajes(admi);
		
		
	}
	
	

}
