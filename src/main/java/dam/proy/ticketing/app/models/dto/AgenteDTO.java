package dam.proy.ticketing.app.models.dto;

import dam.proy.ticketing.app.models.Agente;
import dam.proy.ticketing.app.models.Solicitante;
import dam.proy.ticketing.app.models.Usuario;

public class AgenteDTO extends UsuarioDTO
{
	private String grupo;
	private int idGrupo;

	public AgenteDTO() {
	}

	public AgenteDTO(String grupo) {
		this.grupo = grupo;
	}

	public AgenteDTO(int id, String nombre, String apellidos, String email, String perfil, boolean activo, String grupo, int idGrupo) {
		super(id, nombre, apellidos, email, perfil, activo);
		this.grupo = grupo;
		this.idGrupo = idGrupo;
	}

	public AgenteDTO(Usuario usuario, Agente agente) {
		super(usuario.getId(), usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(), usuario.getPerfil().getNombre(), usuario.isActivo());
		this.grupo = agente.getGrupo().getNombre();
		this.idGrupo = agente.getGrupo().getId();
	}

	public AgenteDTO(String grupo, int idGrupo) {
		this.grupo = grupo;
		this.idGrupo = idGrupo;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}
}
