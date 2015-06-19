package model;

import java.util.ArrayList;

public class DiarieroRevistero extends Vendedor {

	public DiarieroRevistero(int codigo, String direccion, ArrayList<Colocacion> colocaciones) {
		super();
		this.direccion = direccion;
		this.codigo=codigo;
		this.colocaciones=colocaciones;
	}
	
	@Override
	protected boolean aceptaTipoPublicacion(String tipo) {
		if(tipo == "Revista" || tipo == "Diario"){
			return true;
		}
		return false;
	}

}
