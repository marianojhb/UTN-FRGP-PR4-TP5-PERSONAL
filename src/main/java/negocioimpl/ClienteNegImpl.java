package negocioimpl;
import daoimpl.*;
import entidad.*;

public class ClienteNegImpl {

	ClienteDaoImpl cd = new ClienteDaoImpl();
	
	public Cliente obtenerUno(int id)
	{
		return cd.obtenerUno(id);
	}
	
	
}
