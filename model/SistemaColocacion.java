package model;

import java.util.ArrayList;
import java.util.Vector;

import persistencia.AdmPersistenciaColocacion;
import persistencia.AdmPersistenciaEdicion;

public class SistemaColocacion {
	private ArrayList<Vendedor> vendedores;
	private ArrayList<Colocacion> colocaciones;
	private ArrayList<ColocacionStrategy> pautas;
	private ArrayList<Publicacion> publicaciones;
	private static SistemaColocacion instancia;
	
	public ArrayList<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}
	
	public Publicacion buscarPublicacion(String nombre){
		for(int i=0; i<publicaciones.size(); i++){
			Publicacion p = publicaciones.get(i);
			if(p.getTitulo().equalsIgnoreCase(nombre)){
				return p;
			}
		}
		return null;
	}

	public SistemaColocacion() {
		super();
		vendedores = new ArrayList<Vendedor>();
		colocaciones = new ArrayList<Colocacion>();
		pautas = new ArrayList<ColocacionStrategy>();
		publicaciones = new ArrayList<Publicacion>();
	}
	
	public static SistemaColocacion getInstancia()
	{
		if (instancia == null)
			instancia = new SistemaColocacion();
		return instancia;
	}
	
	public void nuevaColocacion(int codEdicion, int cantidad, String fechaSalida, ColocacionStrategy estrategia){
		ArrayList<ItemColocacion> items = asignarCargasAColocacion(codEdicion, cantidad, estrategia);
		Colocacion c = new Colocacion(codEdicion, items, fechaSalida, cantidad);
	}
	
	private ArrayList<ItemColocacion> asignarCargasAColocacion(int codEdicion, int totalCarga, ColocacionStrategy estrategia){
		int codPub;
		ArrayList<ItemColocacion> items = new ArrayList();
		
		
		codPub = AdmPersistenciaEdicion.getCodPublicacion(codEdicion);
		Publicacion p = buscarPublicacion(codPub);
		Vector<Object> ultimas3Colocaciones = AdmPersistenciaColocacion.select3Colocaciones(codPub);
	//	System.out.print(ultimas3Colocaciones.get(1));
		return null;
		
	}
	
	/*
	private ArrayList<Colocacion> getUltimas3Colocaciones(Publicacion p){
		// Busco las últimas tres colocaciones de la publicación
		ArrayList<Colocacion> ultimas3Colocaciones = new ArrayList<Colocacion>() ;
		
		
		for(int i=0; i <= colocaciones.size(); i++){
			// Si todavía no encontré las tres ultimas colocaciones
			if(ultimas3Colocaciones.size() < 3){
				if(colocaciones.get(i).isColocacionOfPublicacion(p)){
					Colocacion c = colocaciones.get(i);
					ultimas3Colocaciones.add(c);
				}
			}else{
				break;
			}
		}
 		
		return ultimas3Colocaciones;
		
	}
	*/
	
	private static ItemColocacion calcularItem(Vendedor v, Publicacion p, Edicion e) {
		ArrayList<Edicion> ultimasTres = p.getUltimas3Ediciones();
		System.out.println(ultimasTres);
		return null;
	}

	public ArrayList<Vendedor> getVendedores() {
		return vendedores;
	}
	
	public void setVendedores(ArrayList<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}
	public void agregarVendedor(Vendedor v){
		vendedores.add(v);
	}
	public ArrayList<Colocacion> getColocaciones() {
		return colocaciones;
	}
	public void setColocaciones(ArrayList<Colocacion> colocaciones) {
		this.colocaciones = colocaciones;
	}
	public void agregarColocacion(Colocacion c){
		colocaciones.add(c);
	}
	public ArrayList<ColocacionStrategy> getPautas() {
		return pautas;
	}
	public void setPautas(ArrayList<ColocacionStrategy> pautas) {
		this.pautas = pautas;
	}
	
	public Publicacion buscarPublicacion(int codigo){
		Publicacion p = null;
		for(int i=0; i<publicaciones.size(); i++){
			p = publicaciones.get(i);
			if(p.getCodigo() == codigo){
				return p;
			}
		}
		return null;
	}
	
	public void bajaEdicion(int codEdicion){
		AdmPersistenciaEdicion.getInstancia().delete(codEdicion);
	}
	
	public void modificarEdicion(Edicion e){
		AdmPersistenciaEdicion.getInstancia().update(e);
	}
}