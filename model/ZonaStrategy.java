/*
 * Pauta por zona: se prioriza la colocación de ejemplares a vendedores cuya ubicación
 * coincida con la zona determinada.
 */

package model;

import java.util.ArrayList;

public class ZonaStrategy implements ColocacionStrategy{
	
	@Override
	public void cargar(ArrayList<Colocacion> ultimas3Colocaciones) {
		// Agarro todos los vendedores que participaron en las ultimas 3 colocaciones de la publicación
		// Hay que sortear la collection de vendedores por zona
	}
	
	/*private ArrayList<Vendedor> getVendedoresDeColocaciones(ArrayList<Colocacion> Ultimas3Colocaciones){
		// Agarro todos los vendedores que participaron en las ultimas 3 colocaciones de la publicación
		ArrayList<Vendedor> vendedoresPublicacion = new ArrayList<Vendedor>();
 		for(int i=0; i <= Ultimas3Colocaciones.size(); i++){
			ArrayList<Vendedor> vendedoresColocacion = Ultimas3Colocaciones.get(i).getVendedores();
			for (Vendedor v : vendedoresColocacion){
				if (!vendedoresPublicacion.contains(v))
					vendedoresPublicacion.add(v);
			}
		}
		return vendedoresPublicacion;
	}*/

}
