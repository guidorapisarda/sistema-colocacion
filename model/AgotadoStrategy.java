/*
 * Pauta de agotados: si el vendedor agoto en las últimas X (a definir por el usuario)
 * ediciones se le aumenta la colocación actual según una tabla de agotados. Por ejemplo: 
 * si agoto con 1 se le coloca 3, si agoto con 2 a 5 se lo coloca 5, si agoto con 6 a 10 
 * se le coloca 10. Que un vendedor agote significa que vendió todos los ejemplares que 
 * cargo y su devolución es 0.
 */

package model;

import java.util.ArrayList;

public class AgotadoStrategy implements ColocacionStrategy{

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
			if(devolucion == 0){
	 				// Le doy más ejemplares mediante tabla de agotados
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
