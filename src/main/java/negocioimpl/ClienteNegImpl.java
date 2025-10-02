package negocioimpl;
import daoimpl.*;
import entidad.*;
import negocio.ClienteNeg;

public class ClienteNegImpl implements ClienteNeg{

	ClienteDaoImpl cd = new ClienteDaoImpl();
	
	public Cliente obtenerUno(int id)
	{
		return cd.obtenerUno(id);
	}
	
	
}
