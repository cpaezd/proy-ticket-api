package dam.proy.ticketing.app.services.interfaces;

import dam.proy.ticketing.app.models.dto.*;
import dam.proy.ticketing.app.models.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioDTO> getUsuarios();
    UsuarioDTO getUsuario(int id);
    boolean nuevoUsuario(NuevoUsuarioRequest nur);
    boolean editarUsuario(int id, EditUsuarioRequest eur);
    boolean cambiarEstadoUsuario(int id);
    LoginResponseDTO autentificar(Usuario usuario);
    Usuario buscarPorEmail(String email);
    boolean requestResetPassword(String email);
    boolean changePassword(ChangePasswordRequest changePasswordRequest);
}
