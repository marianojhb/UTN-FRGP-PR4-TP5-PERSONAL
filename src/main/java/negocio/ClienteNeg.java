package negocio;

import java.util.List;

import entidad.Cliente;

public interface ClienteNeg {
	public Cliente obtenerUno(int id);
	public int agregarUno(Cliente cliente);
	public List<Cliente> obtenerTodos();
}
