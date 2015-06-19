package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import model.Edicion;

public class AdmPersistenciaEdicion extends AdministradorPersistencia{
	private static AdmPersistenciaEdicion instancia;
	
	public static AdmPersistenciaEdicion getInstancia()
	{
		if (instancia == null)
			instancia = new AdmPersistenciaEdicion();
		return instancia;
	}
	
	public void insert(Object o) {
		try{
			Edicion e = (Edicion) o;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("insert into A_Interactivas_07.dbo.Ediciones (titulo, precio, fechaSalida, codPub) values (?,?,?,?)");
			s.setString(1, e.getTitulo());
			s.setFloat(2, e.getPrecio());
			s.setString(3, e.getFechaSalida());
			s.setInt(4, e.getCodPub());
			s.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void update(Object o) {
		try{
			Edicion e = (Edicion) o;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("update A_Interactivas_07.dbo.Ediciones set titulo=?, precio=?, fechaSalida=? WHERE codEdicion=?");
			s.setString(1, e.getTitulo());
			s.setFloat(2, e.getPrecio());
			s.setString(3, e.getFechaSalida());
			s.setInt(4, e.getCodigo());
			s.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void delete(Object d) {
		int a = (int) d;
		try{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("delete from A_Interactivas_07.dbo.Ediciones where codEdicion = ?");
			s.setInt(1, a);
			s.executeQuery();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public Vector<Object> select(Object o) {
		return null;
	}
	public static Edicion buscarEdicion(int codigoEdicion){
		Edicion e = null;
		try{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select * from A_Interactivas_07.dbo.Ediciones where codEdicion = ?");
			s.setInt(1, codigoEdicion);
			ResultSet result = s.executeQuery();
			while(result.next()){
				String titulo = result.getString(2);
				Float precio = result.getFloat(3);
				int codPub = result.getInt(4);
				String fechaSalida = result.getString(5);
				e = new Edicion(codigoEdicion, titulo ,precio,fechaSalida,codPub);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return e;
	}
	public static ArrayList<Edicion> buscarEdicionporPublicacion(int codPublic){
		ArrayList<Edicion> ediciones = new ArrayList<Edicion>();
		try{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select * from A_Interactivas_07.dbo.Ediciones where codPub = ?");
			s.setInt(1, codPublic);
			ResultSet result = s.executeQuery();
			while(result.next()){
				int codEdicion = result.getInt(1);
				Edicion actual = buscarEdicion(codEdicion);
				ediciones.add(actual);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ediciones;
		
	}
	public static int getCodPublicacion(int codEdicion){
		int codPub = 0;
		try{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select codPub from A_Interactivas_07.dbo.Ediciones where codEdicion = ?");
			s.setInt(1, codEdicion);
			ResultSet result = s.executeQuery();
			while(result.next()){
				codPub = result.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return codPub;
	}

	public static ArrayList<String> selectEdicionesConPublicacion() {
		try {
			ArrayList<String> ediciones = new ArrayList<String>();
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("SELECT e.codEdicion, e.titulo, p.titulo FROM A_Interactivas_07.dbo.Ediciones e, A_Interactivas_07.dbo.Publicaciones p where e.codPub = p.codPub");
			ResultSet result = s.executeQuery();
			while(result.next()) {
				ediciones.add(Integer.toString(result.getInt(1)) + " - " + result.getString(2) + " - " + result.getString(3));
			}
			return ediciones;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}