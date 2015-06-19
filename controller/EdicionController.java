package controller;

import java.util.ArrayList;

import persistencia.AdmPersistenciaEdicion;
import model.Edicion;
import view.AltaEdicion;

public class EdicionController {
	AltaEdicion view = new AltaEdicion();
	
	public static void AltaEdicion(int codPub, String titulo, float precio, String fechaSalida) {
		new Edicion(codPub, titulo, precio, fechaSalida);
	}
	
	public static ArrayList<String> fillComboPublicaciones(){
		ArrayList<String> publicaciones = PublicacionController.getPublicaciones();
		return publicaciones;
	}

	public static ArrayList<String> fillComboEdiciones() {
		ArrayList<String> ediciones = AdmPersistenciaEdicion.selectEdicionesConPublicacion();
		return ediciones;
	}
	
}
