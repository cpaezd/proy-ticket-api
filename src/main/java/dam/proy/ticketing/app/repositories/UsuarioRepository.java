package dam.proy.ticketing.app.repositories;

import dam.proy.ticketing.app.models.Solicitante;
import dam.proy.ticketing.app.models.Usuario;
import dam.proy.ticketing.app.models.dto.UsuarioDTO;
import dam.proy.ticketing.app.models.enums.EstadoTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Usuario findByEmail(String email);



}
