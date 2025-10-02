package entidad;

public class Usuario {
	private int id_usuario;
	private String usuario;
	private String contrasena;

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usaurio) {
		this.id_usuario = id_usaurio;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", usuario=" + usuario + ", contrasena=" + contrasena + "]";
	}

}
