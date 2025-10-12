package dam.proy.ticketing.app.repositories;

import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.models.enums.EstadoTicket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    // Buscar tickets por usuario (vía solicitante) y estado
    List<Ticket> findBySolicitante_Usuario_IdAndEstadoTicket(Long usuarioId, EstadoTicket estadoTicket);
}
