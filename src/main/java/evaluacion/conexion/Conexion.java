package evaluacion.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Conexion {
	Connection con = null;
	
	public Connection conectar() throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/evaluacion2a","root","sasa"); 
			return con;
		}catch(ClassNotFoundException e) {
			throw new ClassNotFoundException("Driver de conexión no válido");
		}catch(SQLException e) {
			throw new SQLException("Error al intentar conexión a la base de datos");
		}
	}

	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Conexion cn = new Conexion();
		cn.conectar();
	}
}



