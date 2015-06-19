package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import model.Colocacion;
import model.Diariero;
import model.DiarieroRevistero;
import model.Revistero;
import model.Vendedor;
import persistencia.PoolConnection;
import persistencia.AdministradorPersistencia;

public class AdmPersistenciaVendedor extends AdministradorPersistencia{
	private static AdmPersistenciaVendedor instancia;
	private AdmPersistenciaVendedor(){}
	public static AdmPersistenciaVendedor getInstancia(){
		if (instancia == null)
			instancia = new AdmPersistenciaVendedor();
		return instancia;
	}
	public void delete(Object o){
		/*try{
			Vendedor v = (Vendedor) o;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("delete from A_Interactivas_07.dbo.Vendedor where codVend = ?");
			s.setInt(1, v.getCodVend());
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		}catch(Exception e){
			e.printStackTrace();
		}*/
	}
	
	public void insert(Object o){
		/*try{
			Vendedor v = (Vendedor) o;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("insert into A_Interactivas_07.dbo.Vendedor (direccion,codTipoVen) values (?,?)");
			s.setString(2, v.getDireccion());
			s.setInt(3, v.getTipo());
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		}catch(Exception e){
			e.printStackTrace();
		}*/
	}
	public void update(Object o) {}
	
	public Vector<Object> select(Object o) {
		return null;
	}
	
	/*public Vector<Integer> buscarVendedor(Vector<Object> idColocaciones){
		Vector<Integer> idVendedores = new Vector<>();
		try{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select DISTINCT ic.codVend from A_Interactivas_07.dbo.ItemColocacion ic WHERE ic.codColoc in (?, ?, ?)");
			s.setInt(1, (int) idColocaciones.get(0));
			s.setInt(2, (int) idColocaciones.get(1));
			s.setInt(3, (int) idColocaciones.get(2));
			ResultSet resul = s.executeQuery();
			while(resul.next()){
				int idVend = resul.getInt(1);
				idVendedores.add(idVend);
				PoolConnection.getPoolConnection().realeaseConnection(con);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return idVendedores;
		
	}*/ //No se que es todo esto
	
	public Vendedor buscarVendedor(int codVend){
		try{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select * from A_Interactivas_07.dbo.Vendedor where codVend = ?");
			s.setInt(1, codVend);
			ResultSet resul = s.executeQuery();
			while(resul.next()){
				String direcc = resul.getString(2);
				int tipo = resul.getInt(3);
				ArrayList<Colocacion> ic= AdmPersistenciaColocacion.getInstancia().buscarItemsporVendedor(codVend);
				Vendedor v;
				if(tipo == 1)
					v = new Diariero (codVend,direcc, ic);
				else
					if(tipo == 2)
						v = new Revistero (codVend,direcc, ic);
					else
						v = new DiarieroRevistero (codVend,direcc, ic);
				PoolConnection.getPoolConnection().realeaseConnection(con);
				return v; //esto no se si está bien, creo que esta mal
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null; // esto lo mismo
	}
	
	public ArrayList<Vendedor> selectAll(){
		ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
		try{
			Connection c = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = c.prepareStatement("SELECT * FROM A_Interactivas_07.dbo.Vendedor");
			ResultSet rs = s.executeQuery();
			while(rs.next()){
				int codVend = rs.getInt(1);
				String direcc = rs.getString(2);
				int tipo = rs.getInt(3);
				ArrayList<Colocacion> ic= AdmPersistenciaColocacion.getInstancia().buscarItemsporVendedor(codVend);
				Vendedor v;
				if(tipo == 1)
					v = new Diariero (codVend,direcc, ic);
				else
					if(tipo == 2)
						v = new Revistero (codVend,direcc, ic);
					else
						v = new DiarieroRevistero (codVend,direcc, ic);
				vendedores.add(v);
			}
			return vendedores;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
}
