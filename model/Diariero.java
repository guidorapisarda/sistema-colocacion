package model;

import java.util.ArrayList;

public class Diariero extends Vendedor {
	
	public Diariero(int codigo, String direccion, ArrayList<Colocacion> colocaciones) {
		super();
		this.direccion = direccion;
		this.codigo=codigo;
		this.colocaciones = colocaciones;
	}

	@Override
	protected boolean aceptaTipoPublicacion(String tipo) {
		if(tipo == "Diario"){
			return true;
		}
		return false;
	}
	
}
