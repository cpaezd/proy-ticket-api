package dam.proy.ticketing.app.repositories;

import dam.proy.ticketing.app.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Usuario findByEmail(String email);
}
