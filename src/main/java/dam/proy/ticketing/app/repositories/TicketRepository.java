package dam.proy.ticketing.app.repositories;

import dam.proy.ticketing.app.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
