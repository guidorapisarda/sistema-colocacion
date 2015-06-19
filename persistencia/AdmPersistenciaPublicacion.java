package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import model.Edicion;
import model.Publicacion;

public class AdmPersistenciaPublicacion extends AdministradorPersistencia{

	public static Publicacion buscarPublicacion(int codPub) {
		Publicacion p = null;
		try{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select * from A_Interactivas_07.dbo.Publicaciones where codPub = ?");
			s.setInt(1, codPub);
			ResultSet result = s.executeQuery();
			while(result.next()){
				String titulo = result.getString(2);
				int tipo = result.getInt(3);
				s = con.prepareStatement("select descripcion from A_Interactivas_07.dbo.Publicaciones where codTipoPub = ?");
				//creo una nueva sentencia en SQL para obtener solo la descripcion asociada al int correspondiente al tipo
				s.setInt(1, tipo); //obtengo el int que corresponde al tipo
				ResultSet resultado2 = s.executeQuery(); //ejecuto la sentencia 
				String tipodescripcion = resultado2.getString(1); //guardo en el String el único resultado encontrado (como restringí el select, sólo devuelve la descripcion
				String editor = result.getString(4);
				String tema = result.getString(5);
				String subtema = result.getString(6);
				String publico = result.getString(7);
				String periodicidad = result.getString(8);
				String idioma = result.getString(9);
				String pais = result.getString(10);
				ArrayList<Edicion> ediciones = AdmPersistenciaEdicion.buscarEdicionporPublicacion(codPub);
				p = new Publicacion(codPub,titulo,tipodescripcion,editor,tema,subtema,publico,periodicidad,idioma,pais,ediciones);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return p;
	}

	public void insert(Object o) {
		/*try{
			Publicacion p = (Publicacion) o;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("insert into A_Interactivas_07.dbo.Publicaciones (titulo,tipo,editor,tema,subtema,publico,periodicidad,idioma,pais) values (?,?,?,?,?,?,?,?,?");
			s.setString(1,p.getTitulo());
			s.setInt(2, this.buscarTipo(p.getTipo())); //llama a la funcion que devuelve el codigo del tipo asociado a la descripcion ingresada (supone que siempre lo encuentra).
			s.setString(3, p.getEditor());
			s.setString(4, p.getTema());
			s.setString(5, p.getSubtema());
			s.setString(6, p.getPublico());
			s.setString(7, p.getPeriodicidad());
			s.setString(8, p.getIdioma());
			s.setString(9, p.getPais());
			
		}catch(Exception e){
			e.printStackTrace();
		}*/
	}
	
	public int buscarTipo(String descrip){
		int tipo = 0;
		try{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select * from A_Interactivas_07.dbo.Publicaciones where descripcion = ?");
			s.setString(1, descrip);
			ResultSet result = s.executeQuery();
			while(result.next()){
				tipo = result.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return tipo;
	}
	public void update(Object o) {}
	public void delete(Object d) {} //no se si corresponde implementar
	public Vector<Object> select(Object o) {return null;}

	public static ArrayList<String> selectAll() {

		try {
			ArrayList<String> publicaciones = new ArrayList<String>();
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("SELECT codPub, titulo FROM A_Interactivas_07.dbo.Publicaciones");
			ResultSet result = s.executeQuery();
			while(result.next()) {
				publicaciones.add(Integer.toString(result.getInt(1)) + " - " + result.getString(2));
			}
			return publicaciones;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
