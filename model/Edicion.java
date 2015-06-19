/*
 * Una edición es cada una de las salidas de la publicación, la información que 
 * la registra es: código edición, titulo de tapa, precio, fecha de salida.
 */

package model;

public class Edicion {
	private int codigo;
	private String titulo;
	private float precio;
	private String fechaSalida;
	private int codPub;
	
	public Edicion(int codigo, String titulo, float precio, String fechaSalida, int codPub){
		this.codigo = codigo;
		this.titulo = titulo;
		this.precio = precio;
		this.fechaSalida = fechaSalida;
		this.codPub = codPub;
	}
	
	public int getCodPub() {
		return codPub;
	}

	public void setCodPub(int codPub) {
		this.codPub = codPub;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}	
}
