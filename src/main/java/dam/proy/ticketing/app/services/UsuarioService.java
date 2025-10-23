package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.models.Agente;
import dam.proy.ticketing.app.models.Grupo;
import dam.proy.ticketing.app.models.Solicitante;
import dam.proy.ticketing.app.models.dto.*;
import dam.proy.ticketing.app.models.Usuario;
import dam.proy.ticketing.app.repositories.UsuarioRepository;
import dam.proy.ticketing.app.security.JwtUtil;
import dam.proy.ticketing.app.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private AgenteService agenteService;

	@Autowired
	private SolicitanteService solicitanteService;

	@Autowired
	private JwtUtil jwtUtil;

	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	//LOGIN
	@Override
	public LoginResponseDTO autentificar(Usuario usuario) {
		java.util.Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(usuario.getEmail());


		if (usuarioOptional.isPresent()) {


			Usuario usuario1 = usuarioOptional.get();


			if (passwordEncoder.matches(usuario.getPassword(), usuario1.getPassword())) {

				String token = jwtUtil.generarToken(usuario1.getEmail());
				LoginResponseDTO usuario2 = new LoginResponseDTO();
				usuario2.setToken(token);
				usuario2.setId_perfil(usuario1.getPerfil().getId());
				usuario2.setNombre_perfil(usuario1.getPerfil().getNombre());
				usuario2.setNombre(usuario1.getNombre());
				usuario2.setApellidos(usuario1.getApellidos());
				usuario2.setEmail(usuario1.getEmail());

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

			solicitante.setId((int) pivot.getId());
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
			agente.setId((int) pivot.getId());

			try {
				this.agenteService.nuevoAgente(agente);
			} catch (Exception e) {
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean editarUsuario(int id, Usuario usuario) {
		return false;
	}

	@Override
	public boolean cambiarEstadoUsuario(int id) {
		return false;
	}
}
