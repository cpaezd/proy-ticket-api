package dam.proy.ticketing.app.repositories;

import dam.proy.ticketing.app.models.Solicitante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface SolicitanteRepository extends JpaRepository<Solicitante, Integer> {

    /**
     * Busca en Solicitante -> Usuario -> Email
     */
    Optional<Solicitante> findByUsuario_Email(String email);
}