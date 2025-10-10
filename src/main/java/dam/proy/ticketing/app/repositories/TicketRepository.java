package dam.proy.ticketing.app.repositories;

import dam.proy.ticketing.app.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {


}
