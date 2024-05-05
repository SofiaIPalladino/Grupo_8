package chofer;

import sistema.Empresa;
import usuario.Usuario;

public class GestionPagoChoferes {
	
	Empresa e=Empresa.getInstance();
	
	public void calculoPagoChoferes(Usuario usuario) {
		if (usuario.isAdmin()) {
			
		}else {
			System.out.println("Solo el administrador puede pagar los salarios");	
		}
		
	}

}
