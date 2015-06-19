package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import persistencia.PoolConnection;
import persistencia.AdministradorPersistencia;
import model.Colocacion;
//import model.Edicion;
import model.ItemColocacion;

public class AdmPersistenciaColocacion extends AdministradorPersistencia
{
	private static AdmPersistenciaColocacion instancia;
	
	private AdmPersistenciaColocacion(){
		
	}
	public static AdmPersistenciaColocacion getInstancia(){
		if (instancia == null)
			instancia = new AdmPersistenciaColocacion();
		return instancia;
	}
	public void delete(Object d) 
	{
		try
		{
			Colocacion c = (Colocacion)d;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("delete from A_Interactivas_07.dbo.Colocaciones where codColoc = ?");
			s.setLong(1, c.getCodColocacion());
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void insert(Object d){
		try{
			
			Colocacion c = (Colocacion) d;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("insert into A_Interactivas_07.dbo.Colocaciones (fechaColoc, codEdicion, cantidad) values (?,?,?)");
			s.setString(1, c.getFechaSalida());
			s.setInt(2, c.getCodEdicion());
			s.setInt(3, c.getCantidad());
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void update(Object d){}
	
	public static Vector<Object> select3Colocaciones(Object d){
		int c = (int) d;
		Vector<Object> v = new Vector<>();
		
		try{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("SELECT a.codVend, a.carga AS carga1, a.devolucion AS devolucion1, b.carga AS carga2, b.devolucion AS devolucion2, c.carga AS carga3, c.devolucion AS devolucion3 FROM ((SELECT * FROM ItemColocacion where codColoc = (select codColoc FROM (SELECT ROW_NUMBER() OVER (ORDER BY co.codColoc DESC) AS Orden, co.codColoc from dbo.Colocaciones co INNER JOIN dbo.Ediciones e ON co.codEdicion=e.codEdicion INNER JOIN dbo.Publicaciones p ON e.codPub=p.codPub WHERE p.codPub = (SELECT codPub FROM Ediciones WHERE codEdicion = 1)) r WHERE Orden=3)) a INNER JOIN (SELECT * FROM ItemColocacion where codColoc = (select codColoc FROM (SELECT ROW_NUMBER() OVER (ORDER BY co.codColoc DESC) AS Orden, co.codColoc from dbo.Colocaciones co INNER JOIN dbo.Ediciones e ON co.codEdicion=e.codEdicion INNER JOIN dbo.Publicaciones p ON e.codPub=p.codPub WHERE p.codPub = (SELECT codPub FROM Ediciones WHERE codEdicion = 1)) r WHERE Orden=2)) b ON a.codVend = b.codVend INNER JOIN (SELECT * FROM ItemColocacion where codColoc = (select codColoc FROM (SELECT ROW_NUMBER() OVER (ORDER BY co.codColoc DESC) AS Orden, co.codColoc from dbo.Colocaciones co INNER JOIN dbo.Ediciones e ON co.codEdicion=e.codEdicion INNER JOIN dbo.Publicaciones p ON e.codPub=p.codPub WHERE p.codPub = (SELECT codPub FROM Ediciones WHERE codEdicion = 1)) r WHERE Orden=1)) c ON b.codVend = c.codVend)");
			s.setLong(1, c);
			
			ResultSet result = s.executeQuery();
			while(result.next()){
				v.add(result.getInt(1));
			}		
		}catch(Exception e){
			e.printStackTrace();
		}
		return v;
	}
	
	public Vector<Object> select(Object d){
		return null;
	}
	
	public Colocacion buscarColocacion(long cod){
		Colocacion c = null;
		try{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select * from A_Interactivas_07.dbo.Colocaciones where codColoc=?");
			s.setLong(1, cod);
			
			ResultSet result = s.executeQuery();
			while(result.next()){
				int codColocacion = result.getInt(1);
				String fecha = result.getString(2);
				int codEdicion = result.getInt(3);
				int cantidad = result.getInt(4);
				//Edicion e = AdmPersistenciaEdicion.buscarEdicion(codEdicion);
				ArrayList<ItemColocacion> ic = this.buscarItems(cod);
				c = new Colocacion(codColocacion,codEdicion,ic,fecha,cantidad);
			}		
		}catch(Exception e){
			e.printStackTrace();
		}
		return c;
	}
	public ArrayList<ItemColocacion> buscarItems(long cod) {
		return null;
	}
	public ArrayList<Colocacion> buscarItemsporVendedor(int codVend) {
		try{
			ArrayList<Colocacion> colocaciones = new ArrayList<Colocacion>();
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select * from A_Interactivas_07.dbo.ItemColocacion where codVend = ?");
			s.setInt(1, codVend);
			ResultSet resul = s.executeQuery();
			while(resul.next()){
				int codColoc = resul.getInt(1);
				Colocacion c = this.buscarColocacion(codColoc); //carga una colocacion y la devuelve
				colocaciones.add(c);
			}
			return colocaciones;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}