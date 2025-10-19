package dam.proy.ticketing.app.repositories;

import dam.proy.ticketing.app.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// 1. Asegúrate de que el ID del Ticket sea Integer
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    /**
     * Esto busca en Ticket -> Solicitante -> Usuario -> Email
     */
    List<Ticket> findBySolicitante_Usuario_Email(String email);


}