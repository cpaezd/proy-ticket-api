package dam.proy.ticketing.app.models.dto;

import dam.proy.ticketing.app.models.Agente;
import dam.proy.ticketing.app.models.Solicitante;
import dam.proy.ticketing.app.models.Usuario;

public class AgenteDTO extends UsuarioDTO
{
	private String grupo;

	public AgenteDTO() {
	}

	public AgenteDTO(String grupo) {
		this.grupo = grupo;
	}

	public AgenteDTO(int id, String nombre, String apellidos, String email, String perfil, boolean activo, String grupo) {
		super(id, nombre, apellidos, email, perfil, activo);
		this.grupo = grupo;
	}

	public AgenteDTO(Usuario usuario, Agente agente) {
		super(usuario.getId(), usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(), usuario.getPerfil().getNombre(), usuario.isActivo());
		this.grupo = agente.getGrupo().getNombre();
	}

	public String getGrupo() {
		return grupo;
	}
}
