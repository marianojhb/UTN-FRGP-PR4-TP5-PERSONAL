package dao;

import java.util.List;

import entidad.Cliente;

public interface ClienteDao {
	public Cliente obtenerUno(int id);
	public int agregarUno(Cliente cliente);
	public List<Cliente> obtenerTodos();
}
