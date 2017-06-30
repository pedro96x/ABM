import java.util.ArrayList;
import java.sql.*;


public class DataPersona {

	public Persona getByDni(int docu){
		Persona p=null;
		ResultSet rs=null;
		PreparedStatement stmt =null;
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(		
					"select nombre, apellido, dni, habilitado from personas where dni=?");
			stmt.setInt(1, docu);
			rs = stmt.executeQuery();
			if(rs!=null && rs.next()){
				p=new Persona();
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setDni(rs.getInt("dni"));
				p.setHabilitado(rs.getBoolean("habilitado"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return p;
	}
	
	
	
	
	
	/*public void setPersona(Persona per){
		
		
		Connection Conexion;
		Conexion = FactoryConexion.getInstancia().getConn();
		
		try{
			String Query = "INSERT INTO abmdb2.personas  VALUES("
                    + "\"" + per.getDni() + "\", "
                    + "\"" + per.getNombre() + "\", "
                    + "\"" + per.getApellido() + "\")";
			 Statement st = Conexion.createStatement();
			 st.executeUpdate(Query);
		} catch (SQLException e) {
			e.printStackTrace();
        }
		
	}
*/		
		
		
	/*//	ResultSet rs=null;
		PreparedStatement =null;
		try {
			//stmt= FactoryConexion.getInstancia().getConn().prepareStatement(		
					//"select nombre, apellido, dni, habilitado from personas where dni=?");
				//	"INSERT INTO abmdb2.personas (dni, nombre, apellido, habilitado) VALUES ('"+per.getDni()+"',"+per.getNombre()+","+per.getApellido()+")");
					String Query = "INSERT INTO abmdb2.personas (dni, nombre, apellido, habilitado) VALUES("
		                    + "\"" + per.getDni() + "\", "
		                    + "\"" + per.getNombre() + "\", "
		                    + "\"" + per.getApellido() + "\")";
			stmt.setInt(1, per.getDni());
			stmt.setString(2, per.getNombre());
			stmt.setString(3, per.getApellido());
		  stmt.executeUpdate(Query);
			
			stmt.close();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
	/*	try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();						"update abmdb2.personas VALUES("
                    																+ "\"" + per.getDni() + "\", "
                    																+ "\"" + per.getNombre() + "\", "
                    																+ "\"" + per.getApellido() + "\")");
		} catch (SQLException e) {
			
			e.printStackTrace();
		};
	*/	
	
public void setPersona(Persona per){
		//String elsql = "INSERT INTO `abmdb2`.`personas` (`dni`, `nombre`, `apellido`, `habilitado`) VALUES (?, ?, ?, '1')";
	PreparedStatement stmt=null;
		//Connection Conexion;
		//Conexion = FactoryConexion.getInstancia().getConn();
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("INSERT INTO `abmdb2`.`personas` (`dni`, `nombre`, `apellido`, `habilitado`) VALUES (?, ?, ?, '1')");
			stmt.setInt(1, per.getDni() );
			stmt.setString(2, per.getNombre() );
			stmt.setString(3, per.getApellido() );
			 stmt.executeUpdate();
			// Conexion.commit();
		} catch (SQLException e) {
			e.printStackTrace();
        }
		
	}


public void deleteByDni(int dni){
	
PreparedStatement stmt=null;
	
	try{
		stmt = FactoryConexion.getInstancia().getConn().prepareStatement("DELETE FROM `abmdb2`.`personas` WHERE dni=?");
		stmt.setInt(1, dni );
		 stmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
    }
	
}

public void actualiza(Persona per){
	
PreparedStatement stmt=null;
	
	try{
		stmt = FactoryConexion.getInstancia().getConn().prepareStatement("UPDATE `abmdb2`.`personas` SET dni = ?, nombre = ?, apellido = ? WHERE dni = ?");
		stmt.setInt(1, per.getDni() );
		stmt.setString(2, per.getNombre() );
		stmt.setString(3, per.getApellido() );
		stmt.setInt(4, per.getDni() );
		 stmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
    }
	
}




}
