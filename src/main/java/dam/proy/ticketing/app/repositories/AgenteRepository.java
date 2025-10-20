package dam.proy.ticketing.app.repositories;

import dam.proy.ticketing.app.models.Agente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgenteRepository  extends JpaRepository<Agente,Integer> {

    @Query("SELECT a FROM Agente a WHERE a.grupo.id = :id_grupo")
    List<Agente> buscarPorGrupo(int id_grupo);

    Agente findByUsuario_Id(int id);
}
