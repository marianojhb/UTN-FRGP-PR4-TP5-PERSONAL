package daoimpl;

import dao.ClienteDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entidad.*;

public class ClienteDaoImpl implements ClienteDao {

	@Override
	public Cliente obtenerUno(int id) {
		Conexion cn = new Conexion();
		cn.Open();
		Cliente cliente = new Cliente();

		try {
			String query = "SELECT * FROM clientes WHERE id_cliente = ?";
			PreparedStatement ps = cn.Open().prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cliente.setId_cliente(rs.getInt("id_cliente"));
				cliente.setDni(rs.getString("dni"));
				cliente.setCuil(rs.getString("cuil"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellido(rs.getString("apellido"));
				cliente.setSexo(rs.getString("sexo"));
				cliente.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setNacionalidad(rs.getString("nacionalidad"));
				cliente.setLocalidad(rs.getString("localidad"));
				cliente.setProvincia(rs.getString("provincia"));
				cliente.setCorreo_electronico(rs.getString("correo_electronico"));
				cliente.setTelefono(rs.getString("telefono"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			cn.close();
		}

		return cliente;

	}

	@Override
	public int agregarUno(Cliente cliente) {
		Conexion cn = new Conexion();
		cn.Open();
		int response = -1;
		try {
			String query = "INSERT INTO clientes (dni, cuil, nombre, apellido, sexo, fecha_nacimiento, direccion, nacionalidad, localidad, provincia, correo_electronico, telefono) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement ps = cn.Open().prepareStatement(query);
			ps.setString(1, cliente.getDni());
			ps.setString(2, cliente.getCuil());
			ps.setString(3, cliente.getNombre());
			ps.setString(4, cliente.getApellido());
			ps.setString(5, cliente.getSexo());
			ps.setString(6, cliente.getFecha_nacimiento());
			ps.setString(7, cliente.getDireccion());
			ps.setString(8, cliente.getNacionalidad());
			ps.setString(9, cliente.getLocalidad());
			ps.setString(10, cliente.getProvincia());
			ps.setString(11, cliente.getCorreo_electronico());
			ps.setString(12, cliente.getTelefono());
			response = ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
		finally {
			cn.close();
		}
		return response;
	}

	@Override
	public List<Cliente> obtenerTodos() {
		Conexion cn = new Conexion();
		cn.Open();
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			String query = "SELECT * FROM clientes";
			Statement st = cn.Open().createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next())
			{
				Cliente cliente = new Cliente();
				cliente.setId_cliente(rs.getInt("id_cliente"));
				cliente.setDni(rs.getString("dni"));
				cliente.setCuil(rs.getString("cuil"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellido(rs.getString("apellido"));
				cliente.setSexo(rs.getString("sexo"));
				cliente.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setNacionalidad(rs.getString("nacionalidad"));
				cliente.setLocalidad(rs.getString("localidad"));
				cliente.setProvincia(rs.getString("provincia"));
				cliente.setCorreo_electronico(rs.getString("correo_electronico"));
				cliente.setTelefono(rs.getString("telefono"));
				clientes.add(cliente);
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally {
			cn.close();
		}
		
		return clientes;
	}
}
