package model;

import java.util.ArrayList;

public class Revistero extends Vendedor {
	
	public Revistero(int codigo, String direccion, ArrayList<Colocacion> colocaciones) {
		super();
		this.direccion = direccion;
		this.codigo=codigo;
		this.colocaciones = colocaciones;
	}
	
	@Override
	protected boolean aceptaTipoPublicacion(String tipo) {
		if(tipo == "Revista"){
			return true;
		}
		return false;
	}


}
