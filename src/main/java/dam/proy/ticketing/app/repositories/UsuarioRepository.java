package dam.proy.ticketing.app.repositories;

import dam.proy.ticketing.app.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional; // 👈 1. Importa esto

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    /**
     * Devuelve Optional<Usuario>
     * Esto es crucial para que el service maneje si un usuario no existe.
     */
    Optional<Usuario> findByEmail(String email);
}