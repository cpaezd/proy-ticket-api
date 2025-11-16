package dam.proy.ticketing.app.services.interfaces;

import dam.proy.ticketing.app.models.dto.EditUsuarioRequest;
import dam.proy.ticketing.app.models.dto.LoginResponseDTO;
import dam.proy.ticketing.app.models.Usuario;
import dam.proy.ticketing.app.models.dto.NuevoUsuarioRequest;
import dam.proy.ticketing.app.models.dto.UsuarioDTO;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioDTO> getUsuarios();
    UsuarioDTO getUsuario(int id);
    boolean nuevoUsuario(NuevoUsuarioRequest nur);
    boolean editarUsuario(int id, EditUsuarioRequest eur);
    boolean cambiarEstadoUsuario(int id);
    LoginResponseDTO autentificar(Usuario usuario);
    Usuario buscarPorEmail(String email);
        // boolean nuevoUsuario(Usuario nuevo)
}
