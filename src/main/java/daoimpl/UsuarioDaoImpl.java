package daoimpl;
import java.sql.*;

import dao.UsuarioDao;

public class UsuarioDaoImpl implements UsuarioDao {
	public boolean login (String username, String password) {
		
		Conexion cn = new Conexion();
		cn.Open();
		try {
			String query = "SELECT * FROM USUARIOS WHERE usuario=? AND contrasena=?";
			PreparedStatement ps = cn.Open().prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next())
			{
				return true;
			}
			
		} catch (SQLException exception)
		{
			exception.printStackTrace();
		}
		return false;
	}
}