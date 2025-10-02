package daoimpl;

import dao.ClienteDao;
import java.sql.*;
import entidad.*;

public class ClienteDaoImpl implements ClienteDao {

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
				cliente.setId_Cliente(rs.getInt("id_cliente"));
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
}
