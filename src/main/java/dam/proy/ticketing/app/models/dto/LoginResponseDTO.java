package dam.proy.ticketing.app.models.dto;

import dam.proy.ticketing.app.models.Usuario;

public class LoginResponseDTO {

	private String token;
	private int id_perfil;
	private String nombre_perfil;
	private String nombre;
	private String apellidos;
	private String email;
	private int id_grupo;

	public LoginResponseDTO() {
	}

	public LoginResponseDTO(String token, String email, String apellidos, String nombre, String nombre_perfil, int id_perfil) {
		this.token = token;
		this.email = email;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.nombre_perfil = nombre_perfil;
		this.id_perfil = id_perfil;
	}

	public LoginResponseDTO(String token, Usuario usuario) {
		this.token = token;
		this.email = usuario.getEmail();
		this.apellidos = usuario.getApellidos();
		this.nombre = usuario.getNombre();
		this.nombre_perfil = usuario.getPerfil().getNombre();
		this.id_perfil = usuario.getPerfil().getId();
	}

	public LoginResponseDTO(String token, int id_grupo, String email, String nombre, String apellidos, String nombre_perfil, int id_perfil) {
		this.token = token;
		this.id_grupo = id_grupo;
		this.email = email;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombre_perfil = nombre_perfil;
		this.id_perfil = id_perfil;
	}

	public int getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(int id_grupo) {
		this.id_grupo = id_grupo;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre_perfil() {
		return nombre_perfil;
	}

	public void setNombre_perfil(String nombre_perfil) {
		this.nombre_perfil = nombre_perfil;
	}

	public int getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(int id_perfil) {
		this.id_perfil = id_perfil;
	}

	@Override
	public String toString() {
		return "LoginRespuestaDTO{" +
				"token='" + token + '\'' +
				", id_perfil=" + id_perfil +
				", nombre_perfil='" + nombre_perfil + '\'' +
				", nombre='" + nombre + '\'' +
				", apellidos='" + apellidos + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
