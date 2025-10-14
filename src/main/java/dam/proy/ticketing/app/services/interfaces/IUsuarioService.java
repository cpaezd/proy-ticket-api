package dam.proy.ticketing.app.services.interfaces;

import dam.proy.ticketing.app.models.dto.LoginResponseDTO;
import dam.proy.ticketing.app.models.Usuario;

import java.util.List;

public interface IUsuarioService {
    LoginResponseDTO autentificar(Usuario usuario);
    Usuario buscarPorEmail(String email);
    List<Usuario> getUsuarios();
    // boolean nuevoUsuario(Usuario nuevo)
}
