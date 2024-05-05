package chofer;

import java.util.List;

import sistema.Empresa;
import usuario.Usuario;

public class GestionPagoChoferes {
	
	Empresa e=Empresa.getInstance();
	
	public void calculoPagoChoferes() {
			double sueldo=0;
			double totalsueldos=0;
			Chofer choferaux=null;
			
			List<Chofer> choferes=e.getChoferes();
			for(int i=0;i<choferes.size();i++) {
				choferaux=choferes.get(i);
				sueldo=choferaux.getSueldo();
				totalsueldos+=sueldo;
				System.out.println("El chofer: "+choferaux.getNombre()+" tiene que cobrar $"+sueldo);
			}
			System.out.println("Total de dinero a pagar por los sueldos: "+totalsueldos);
	}

}
