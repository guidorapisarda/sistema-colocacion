/*
 * El sistema maneja información de venta de los vendedores. Cada vendedor 
 * es un puesto de diarios y revistas ubicado en un punto de la ciudad. 
 * Del vendedor se conoce su dirección,  su tipo (diariero exclusivo, revistero 
 * exclusivo o ambos) y la venta de cada una de las publicaciones que lleva (carga, 
 * devolución).
 */

package model;

import java.util.ArrayList;

public abstract class Vendedor {
	protected int codigo;
	protected String direccion;
	protected ArrayList<Colocacion> colocaciones;
	
	/*public Vendedor(int cod, String dir){
		this.codigo = cod;
		this.direccion = dir;
	}*/
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	protected abstract boolean aceptaTipoPublicacion(String tipo);
}
