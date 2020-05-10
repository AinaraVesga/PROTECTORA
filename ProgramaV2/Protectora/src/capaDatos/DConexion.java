package capaDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DConexion {
	
	/*public static void main(String[] args) {
		CmdUsuarios();		
	}*/
	
	public static Connection Conectar() {
		String ruta = "C:/DATOS/DatabaseProtectora.db";
		try {
			Class.forName("org.sqlite.JDBC");
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:" + ruta);
			System.out.println("Conexión Ok - Ruta: " + ruta);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
