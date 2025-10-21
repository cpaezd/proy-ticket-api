package dam.proy.ticketing.app.models.dto;

public class NuevoUsuarioRequest
{
	private String nombre;
	private String apellidos;
	private String email;
	private int perfil;
	private String password;

	private int grupo;

	private String empresa;
	private String telefono;
	private String cif;

	public NuevoUsuarioRequest()
	{

	}

	public NuevoUsuarioRequest(String nombre, String apellidos, String email, int perfil, String password, int grupo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.perfil = perfil;
		this.password = password;
		this.grupo = grupo;
	}

	public NuevoUsuarioRequest(String nombre, String apellidos, String email, int perfil, String password, String empresa, String telefono, String cif) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.perfil = perfil;
		this.password = password;
		this.empresa = empresa;
		this.telefono = telefono;
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getEmail() {
		return email;
	}

	public int getPerfil() {
		return perfil;
	}

	public String getPassword() {
		return password;
	}

	public int getGrupo() {
		return grupo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getCif() {
		return cif;
	}
}
