package controller;

import java.util.ArrayList;

import persistencia.AdmPersistenciaPublicacion;
import model.Publicacion;

public class PublicacionController {
	
	public static ArrayList<String> getPublicaciones(){
		ArrayList<String> publicaciones = AdmPersistenciaPublicacion.selectAll();
		return publicaciones;
	}
	
} 
