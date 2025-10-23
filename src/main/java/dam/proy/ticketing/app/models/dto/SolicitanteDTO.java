package dam.proy.ticketing.app.models.dto;

import dam.proy.ticketing.app.models.Solicitante;
import dam.proy.ticketing.app.models.Usuario;

public class SolicitanteDTO extends UsuarioDTO {
	private String empresa;
	private String telefono;
	private String cif;

	public SolicitanteDTO() {
	}

	public SolicitanteDTO(int id, String nombre, String apellidos, String email, String perfil, boolean activo, String empresa, String telefono, String cif) {
		super(id, nombre, apellidos, email, perfil, activo);
		this.empresa = empresa;
		this.telefono = telefono;
		this.cif = cif;
	}

	public SolicitanteDTO(Usuario usuario, Solicitante solicitante) {
		super(usuario.getId(), usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(), usuario.getPerfil().getNombre(), usuario.isActivo());
		this.empresa = solicitante.getEmpresa();
		this.telefono = solicitante.getTelefono();
		this.cif = solicitante.getCif();
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}
}
