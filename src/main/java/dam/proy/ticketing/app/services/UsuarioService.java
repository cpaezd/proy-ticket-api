package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.dto.LoginRespuestaDTO;
import dam.proy.ticketing.app.models.Usuario;
import dam.proy.ticketing.app.repositories.UsuarioRepository;
import dam.proy.ticketing.app.security.JwtUtil;
import dam.proy.ticketing.app.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    //LOGIN
    @Override
    public LoginRespuestaDTO autentificar(Usuario usuario) {
        Usuario usuario1 = usuarioRepository.findByEmail(usuario.getEmail());

        if(usuario1 != null && passwordEncoder.matches(usuario.getPassword(),usuario1.getPassword())&& usuario1.isActivo()==true){

            String token = jwtUtil.generarToken(usuario1.getEmail());

            LoginRespuestaDTO usuario2 = new LoginRespuestaDTO();

            usuario2.setToken(token);
            usuario2.setId_perfil(usuario1.getPerfil().getId());
            usuario2.setNombre_perfil(usuario1.getPerfil().getNombre());
            usuario2.setNombre(usuario1.getNombre());
            usuario2.setApellidos(usuario1.getApellidos());
            usuario2.setEmail(usuario1.getEmail());

            return usuario2;


        }

        return null;
    }

    //Lo usamos en Jwt
    @Override
    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
