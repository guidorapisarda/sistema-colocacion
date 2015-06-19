/*
 * Pauta exceso devolución: si el vendedor devolvió más ejemplares de los que cargo se lo
 * penaliza disminuyendo su colocación actual en base a una tabla de exceso.
 */

package model;

import java.util.ArrayList;

public class ExcesoDevolucionStrategy implements ColocacionStrategy{

	@Override
	public void cargar(ArrayList<Colocacion> ultimas3Colocaciones) {
		// Agarro todos los vendedores que participaron en las ultimas 3 colocaciones de la publicación
		ArrayList<Vendedor> vendedoresPublicacion = getVendedoresDeColocaciones(ultimas3Colocaciones);
		//Colocacion nuevaColocacion;
		ArrayList<ItemColocacion> itemsColocacion = null;
		int devolucion = 0;
		int carga = 0;
		for(int j = 0; j<= vendedoresPublicacion.size(); j++){
			for(int i = 0; i<= ultimas3Colocaciones.size(); i++){
 	 			ItemColocacion item = ultimas3Colocaciones.get(i).getItemDeVendedor(vendedoresPublicacion.get(j));
 	 			devolucion = devolucion + item.getDevolucion();
 	 			carga = item.getCarga();
 	 		}
			if(devolucion > carga){
	 				// Penalizo con menos ejemplares mediante tabla de excedente
	 				int cargaNueva = 0;
	 				ItemColocacion itemVendedor = new ItemColocacion(vendedoresPublicacion.get(j), cargaNueva, 0); /* TODO IMPLEMENTAR Carga nueva */
	 				itemsColocacion.add(itemVendedor);
 			}else{
 				// Pongo la misma ultima carga
 				ItemColocacion itemVendedor = new ItemColocacion(vendedoresPublicacion.get(j), carga, 0); /* TODO IMPLEMENTAR Carga nueva */
 			}
 		}
				
	}
	
	private ArrayList<Vendedor> getVendedoresDeColocaciones(ArrayList<Colocacion> Ultimas3Colocaciones){
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
	}

}
