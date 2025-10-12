package dam.proy.ticketing.app.services.interfaces;

import dam.proy.ticketing.app.models.dto.LoginResponseDTO;
import dam.proy.ticketing.app.models.Usuario;

public interface IUsuarioService {
    public LoginResponseDTO autentificar(Usuario usuario);
    public Usuario buscarPorEmail(String email);
    // boolean nuevoUsuario(Usuario nuevo)
}
