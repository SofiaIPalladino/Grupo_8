package org.grupo8.excepciones;

public class ViajeNoEncontradoException extends Exception {
	public ViajeNoEncontradoException() {
		super("No se encontró viaje a pagar");
	}
}
