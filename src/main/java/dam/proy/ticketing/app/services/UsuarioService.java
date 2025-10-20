package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.models.dto.LoginResponseDTO;
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
    public List<Usuario> getUsuarios() {
        return this.usuarioRepository.findAll();
    }
}
