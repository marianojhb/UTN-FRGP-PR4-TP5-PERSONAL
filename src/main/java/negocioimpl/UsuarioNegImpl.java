package negocioimpl;
import dao.*;
import daoimpl.UsuarioDaoImpl;
import entidad.Usuario;

public class UsuarioNegImpl {
	UsuarioDaoImpl ud = new UsuarioDaoImpl();
	
	public boolean login(String username, String password) {
		return ud.login(username, password);
	}
}
