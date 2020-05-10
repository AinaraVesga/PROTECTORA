package capaDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DLogin {
	
	/*public static void main(String[] args) {
		CmdBuscarUsuario("AINARA", "1234");		
	}*/
	
	public static ResultSet CmdBuscarUsuario(String usuario, String pw) {
		Connection conn = DConexion.Conectar();
		ResultSet res = null;
		
		try {
			Statement enunciado = conn.createStatement();
						
			res = enunciado.executeQuery("SELECT * FROM USUARIOS WHERE NOMBRE LIKE '" + usuario + "' AND PW LIKE '" + pw + "';");
			
			/*while (res.next()) {
				System.out.println(res.getString(1) + " " + res.getString(2) + " " + res.getString(3));
			}*/
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
