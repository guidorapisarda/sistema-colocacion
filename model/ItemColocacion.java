package model;

public class ItemColocacion {
	private Vendedor vendedor;
	private int carga;
	private int devolucion; /* PREGUNTAR */
	
	public ItemColocacion(Vendedor vendedor, int carga, int devolucion) {
		super();
		this.vendedor = vendedor;
		this.carga = carga;
		this.devolucion = devolucion;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public int getCarga() {
		return carga;
	}
	public void setCarga(int carga) {
		this.carga = carga;
	}
	public int getDevolucion() {
		return devolucion;
	}
	public void setDevolucion(int devolucion) {
		this.devolucion = devolucion;
	}
}
