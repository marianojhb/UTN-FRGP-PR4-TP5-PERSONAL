package negocioimpl;
import dao.*;
import daoimpl.UsuarioDaoImpl;
import entidad.Usuario;
import negocio.UsuarioNeg;

public class UsuarioNegImpl implements UsuarioNeg {
	UsuarioDaoImpl ud = new UsuarioDaoImpl();
	
	public boolean login(String username, String password) {
		return ud.login(username, password);
	}
}
