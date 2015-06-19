/*
 * Una publicación está integrada por la siguiente información: código, 
 * titulo, tipo publicación, editor, tema, subtema, publico, periodicidad, 
 * idioma, país de origen. Por ejemplo, diario La Nación.
 */

package model;

import java.util.ArrayList;

public class Publicacion {
	private int codigo;
	private String titulo;
	private String tipo;
	private String editor;
	private String tema;
	private String subtema;
	private String publico;
	private String periodicidad;
	private String idioma;
	private String pais;
	private ArrayList<Edicion> ediciones = new ArrayList<Edicion>();
	
	public Publicacion(int codigo, String titulo, String tipo, String editor, String tema, String subtema, String publico, String periodicidad, String idioma, String pais, ArrayList<Edicion> ediciones){
		this.codigo = codigo;
		this.titulo = titulo;
		this.tipo = tipo;
		this.editor = editor;
		this.tema = tema;
		this.subtema = subtema;
		this.publico = publico;
		this.periodicidad = periodicidad;
		this.idioma = idioma;
		this.pais = pais;
		this.ediciones = new ArrayList<Edicion>();
	}
	
	public ArrayList<Edicion> getUltimas3Ediciones(){
		ArrayList<Edicion> TresEdiciones = new ArrayList<Edicion>();
		if(this.tipo == "Diario"){
			TresEdiciones.add(this.getEdiciones().get(getEdiciones().size()));
			TresEdiciones.add(this.getEdiciones().get(getEdiciones().size()-7));
			TresEdiciones.add(this.getEdiciones().get(getEdiciones().size()-14));
		}else{
			TresEdiciones.add(this.getEdiciones().get(getEdiciones().size()));
			TresEdiciones.add(this.getEdiciones().get(getEdiciones().size()-1));
			TresEdiciones.add(this.getEdiciones().get(getEdiciones().size()-2));
		}
		return TresEdiciones;
	}
	
	public ArrayList<Edicion> getEdiciones() {
		return ediciones;
	}

	public void setEdiciones(ArrayList<Edicion> ediciones) {
		this.ediciones = ediciones;
	}
	public void addEdicion(Edicion e){
		ediciones.add(e);
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public String getSubtema() {
		return subtema;
	}
	public void setSubtema(String subtema) {
		this.subtema = subtema;
	}
	public String getPublico() {
		return publico;
	}
	public void setPublico(String publico) {
		this.publico = publico;
	}
	public String getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
}
