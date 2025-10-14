package dam.proy.ticketing.app.repositories;

import dam.proy.ticketing.app.models.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoRepository extends JpaRepository<Grupo,Integer> {

    Grupo findByNombre(String nombre);
}
