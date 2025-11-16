package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.models.Agente;
import dam.proy.ticketing.app.models.Grupo;
import dam.proy.ticketing.app.models.Solicitante;
import dam.proy.ticketing.app.models.dto.*;
import dam.proy.ticketing.app.models.Usuario;
import dam.proy.ticketing.app.repositories.AgenteRepository;
import dam.proy.ticketing.app.repositories.UsuarioRepository;
import dam.proy.ticketing.app.security.JwtUtil;
import dam.proy.ticketing.app.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private AgenteService agenteService;

	@Autowired
	private SolicitanteService solicitanteService;

	@Autowired
	private AgenteRepository agenteRepository;

	@Autowired
	private JwtUtil jwtUtil;

	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	//LOGIN
	@Override
	public LoginResponseDTO autentificar(Usuario usuario) {
		java.util.Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(usuario.getEmail());


		if (usuarioOptional.isPresent()) {


			Usuario usuario1 = usuarioOptional.get();
			Agente agente = agenteRepository.findById((int)usuario1.getId()).orElse(null);


			if (passwordEncoder.matches(usuario.getPassword(), usuario1.getPassword())) {

				String token = jwtUtil.generarToken(usuario1.getEmail());
				LoginResponseDTO usuario2 = new LoginResponseDTO();
				usuario2.setToken(token);
				usuario2.setId_perfil(usuario1.getPerfil().getId());
				usuario2.setNombre_perfil(usuario1.getPerfil().getNombre());
				usuario2.setNombre(usuario1.getNombre());
				usuario2.setApellidos(usuario1.getApellidos());
				usuario2.setEmail(usuario1.getEmail());
				usuario2.setId_usuario(usuario1.getId());
				if(agente != null && agente.getGrupo() != null){
					usuario2.setId_grupo(agente.getGrupo().getId());
				}


				return usuario2;
			}
		}


		return null;
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		Usuario usuario = usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado con email: " + email));;
		return usuario;
	}

	@Override
	public List<UsuarioDTO> getUsuarios()
	{
		List<Usuario> usuarios = usuarioRepository.findAll();

		return usuarios
			.stream()
			.map(u -> new UsuarioDTO(u))
			.toList();
	}

	@Override
	public UsuarioDTO getUsuario(int id) {
		Usuario user = this.usuarioRepository.findById(id).orElse(null);
		UsuarioDTO userDTO = null;

		if (user == null) {
			return null;
		}

		if(user.getPerfil().getId() == 4) {
			Solicitante s = this.solicitanteService.getSolicitante(user.getId());

			userDTO = new SolicitanteDTO(user, s);
		} else {
			Agente a = this.agenteService.getAgente(user.getId());

			userDTO = new AgenteDTO(user, a);
		}

		return userDTO;
	}

	@Override
	public boolean nuevoUsuario(NuevoUsuarioRequest nur) {
		Usuario nuevo = new Usuario();
		Usuario pivot;

		nuevo.setNombre(nur.getNombre());
		nuevo.setApellidos(nur.getApellidos());
		nuevo.setEmail(nur.getEmail());
		nuevo.setPassword(passwordEncoder.encode(nur.getPassword()));

		try {
			pivot = this.usuarioRepository.save(nuevo);
		} catch (Exception e) {
			return false;
		}

		if(nur.getPerfil() == 4) {
			Solicitante solicitante = new Solicitante();

			solicitante.setId(pivot.getId());
			solicitante.setEmpresa(nur.getEmpresa());
			solicitante.setCif(nur.getCif());

			try {
				this.solicitanteService.nuevoSolicitante(solicitante);
			} catch (Exception e) {
				return false;
			}

		} else {
			Agente agente = new Agente();

			agente.setGrupo(new Grupo(nur.getGrupo()));
			agente.setId( pivot.getId());

			try {
				this.agenteService.nuevoAgente(agente);
			} catch (Exception e) {
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean editarUsuario(int id, EditUsuarioRequest eur) {
		Usuario editar = this.usuarioRepository.findById(id).orElse(null);

		if (editar == null) {
			return false;
		}

		editar.setNombre(eur.getNombre());
		editar.setApellidos(eur.getApellidos());
		editar.setEmail(eur.getEmail());

		if(eur.getPerfil() == 4) {
			Solicitante solicitanteEditar = this.solicitanteService.getSolicitante(editar.getId());

			solicitanteEditar.setTelefono(eur.getTelefono());
			solicitanteEditar.setCif(eur.getCif());
			solicitanteEditar.setEmpresa(eur.getEmpresa());

			this.solicitanteService.updateSolicitante(solicitanteEditar);
		} else {
			Agente agenteEditar = this.agenteService.getAgente(editar.getId());

			agenteEditar.setGrupo(new Grupo(eur.getGrupo()));

			this.agenteService.actualizarAgente(agenteEditar);
		}

		return true;
	}

	@Override
	public boolean cambiarEstadoUsuario(int id) {
		Usuario usuario = this.usuarioRepository.findById(id).orElse(null);

		if(usuario == null) {
			return false;
		}

		usuario.setActivo(!usuario.isActivo());
		this.usuarioRepository.save(usuario);

		return true;
	}
}
