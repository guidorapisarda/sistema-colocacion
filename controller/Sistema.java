package controller;

import java.util.ArrayList;

import model.Colocacion;
import model.ColocacionStrategy;
import model.Edicion;
import model.Publicacion;
import model.Vendedor;
import persistencia.AdmPersistenciaEdicion;
import persistencia.AdmPersistenciaPublicacion;
import persistencia.AdmPersistenciaVendedor;
import view.Menu;

public class Sistema {
	
	private ArrayList<Edicion> ediciones;
	private ArrayList<Vendedor> vendedores;
	private ArrayList<Colocacion> colocaciones;
	private ArrayList<ColocacionStrategy> pautas;
	private ArrayList<Publicacion> publicaciones;
	private static Sistema instancia;
	
	public Sistema() {
		ediciones = new ArrayList<Edicion>();
		vendedores = AdmPersistenciaVendedor.getInstancia().selectAll();
	}

	public ArrayList<Edicion> getEdiciones() {
		return ediciones;
	}

	public static Sistema getInstancia() {
		if(instancia == null)
			instancia = new Sistema();
		return instancia;
	}

	public static void main(String[] args) 
	{
		Menu inst = new Menu();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}
	
	public void AltaEdicion(int codEdicion, int codPub, String titulo, float precio, String fechaSalida) {
		Publicacion p = buscarPublicacion(codPub);
		if(p != null){ //si la publicación existe
			ArrayList<Edicion> aux = p.getEdiciones();
			for(int i=0;i<aux.size();i++){
				if(aux.get(i).getCodigo() == codEdicion) //si quiero cargar una edición con un codigo existente
					return; 
			}
				Edicion e = new Edicion(codEdicion,titulo, precio,fechaSalida, codPub);
				p.addEdicion(e);
				AdmPersistenciaEdicion.getInstancia().insert(e);
				ediciones.add(e);
		}
	}
	public static ArrayList<String> fillComboPublicaciones(){
		ArrayList<String> publicaciones = AdmPersistenciaPublicacion.selectAll();
		return publicaciones;
	}

	public static ArrayList<String> fillComboEdiciones() {
		ArrayList<String> ediciones = AdmPersistenciaEdicion.selectEdicionesConPublicacion();
		return ediciones;
	}
	
	private Publicacion buscarPublicacion(int codPub){
		Publicacion p = null;
		for(int i=0;i<publicaciones.size();i++){
			if(publicaciones.get(i).getCodigo() == codPub)
				return publicaciones.get(i);
		}
		return AdmPersistenciaPublicacion.buscarPublicacion(codPub);
	}
}
