package model;

import java.util.ArrayList;

public class Colocacion {
	private int codColocacion;
	private int codEdicion;
	private ArrayList<ItemColocacion> items;
	private String fechaSalida;
	private int cantidad;
	
	public Colocacion(int codColocacion, int codEdicion, ArrayList<ItemColocacion> items, String fechaSalida, int cantidad) {
		super();
		this.codColocacion = codColocacion;
		this.codEdicion = codEdicion;
		this.items = new ArrayList<ItemColocacion>();
		this.fechaSalida = fechaSalida;
		this.cantidad = cantidad;
	}
	
	public ArrayList<Vendedor> getVendedores(){
		ArrayList<Vendedor> vendedoresDeColocacion = new ArrayList<Vendedor>();
		for(int i=0; i<items.size(); i++){
			Vendedor v = items.get(i).getVendedor();
			vendedoresDeColocacion.add(v);
		}
		return vendedoresDeColocacion;
	}
	
	public ItemColocacion getItemDeVendedor(Vendedor v){
		
		for( int i = 0; i <= this.items.size(); i++ ){
			if(items.get(i).getVendedor().equals(v)){
				ItemColocacion item = items.get(i);
				return item;
			}
		}
		return null;
	}
	
	/*public boolean isColocacionOfPublicacion(Publicacion p){
		if(this.publicacion == p)
			return true;
		return false;
	}*/

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public ArrayList<ItemColocacion> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemColocacion> items) {
		this.items = items;
	}

	public void agregarItem(ItemColocacion item) {
		items.add(item);
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public long getCodColocacion() {
		return codColocacion;
	}

	public int getCodEdicion() {
		return codEdicion;
	}

	public void setCodEdicion(int codEdicion) {
		this.codEdicion = codEdicion;
	}

	public void setCodColocacion(int codColocacion) {
		this.codColocacion = codColocacion;
	}
}
