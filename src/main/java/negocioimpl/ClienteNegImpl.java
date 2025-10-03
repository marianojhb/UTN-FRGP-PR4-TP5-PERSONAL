package negocioimpl;
import java.util.List;

import dao.ClienteDao;
import daoimpl.*;
import entidad.*;
import negocio.ClienteNeg;

public class ClienteNegImpl implements ClienteNeg{

	ClienteDaoImpl cd = new ClienteDaoImpl();
	
	@Override
	public Cliente obtenerUno(int id)
	{
		return cd.obtenerUno(id);
	}

	@Override
	public int agregarUno(Cliente cliente) 
	{
		return cd.agregarUno(cliente);
	}

	@Override
	public List<Cliente> obtenerTodos() {
		return cd.obtenerTodos();
	}
	
	
}
