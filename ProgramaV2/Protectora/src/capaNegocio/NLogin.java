package capaNegocio;

import javax.swing.JOptionPane;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;

import capaDatos.*;
import capaPresentacion.CPLogin;
import capaPresentacion.CPMain;

public class NLogin {
	
	public static int buscarUsuario(String usuario, String pw) {
		if ((usuario.equals("")) || (pw.equals(""))) {
			return 0;
		}
		else {
			ResultSet user = DLogin.CmdBuscarUsuario(usuario, pw);
			try {
				if (!user.next()) {
					return -1;
				}
				else {
					return 1;					
				}
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
	}

}
